import express from 'express';
import cors from 'cors';
import fs from 'fs/promises';
import path from 'path';

const app = express();
const PORT = 3001;

app.use(cors());
app.use(express.json());

// Database file path
const dbPath = path.join(process.cwd(), 'server', 'database.json');

// Initialize database
const initDB = async () => {
  try {
    await fs.access(dbPath);
  } catch {
    // Create initial database with 50 rooms
    const initialData = {
      rooms: [],
      bookings: []
    };
    
    // Generate 50 rooms across different categories
    const categories = [
      { type: 'Standard', price: 120, maxGuests: 2, count: 20 },
      { type: 'Deluxe', price: 180, maxGuests: 3, count: 15 },
      { type: 'Suite', price: 280, maxGuests: 4, count: 10 },
      { type: 'Presidential', price: 450, maxGuests: 4, count: 5 }
    ];
    
    let roomNumber = 1;
    categories.forEach(category => {
      for (let i = 0; i < category.count; i++) {
        initialData.rooms.push({
          id: roomNumber,
          number: `${roomNumber.toString().padStart(3, '0')}`,
          category: category.type,
          price: category.price,
          maxGuests: category.maxGuests,
          amenities: getRoomAmenities(category.type),
          available: true
        });
        roomNumber++;
      }
    });
    
    await fs.writeFile(dbPath, JSON.stringify(initialData, null, 2));
  }
};

const getRoomAmenities = (category) => {
  const baseAmenities = ['WiFi', 'Air Conditioning', 'TV', 'Private Bathroom'];
  switch (category) {
    case 'Standard':
      return [...baseAmenities];
    case 'Deluxe':
      return [...baseAmenities, 'Mini Bar', 'City View', 'Room Service'];
    case 'Suite':
      return [...baseAmenities, 'Mini Bar', 'Ocean View', 'Room Service', 'Balcony', 'Sofa'];
    case 'Presidential':
      return [...baseAmenities, 'Mini Bar', 'Ocean View', 'Room Service', 'Balcony', 'Sofa', 'Jacuzzi', 'Butler Service', 'Kitchen'];
    default:
      return baseAmenities;
  }
};

const readDB = async () => {
  const data = await fs.readFile(dbPath, 'utf-8');
  return JSON.parse(data);
};

const writeDB = async (data) => {
  await fs.writeFile(dbPath, JSON.stringify(data, null, 2));
};

// Initialize database on startup
initDB();

// Get all available rooms
app.get('/api/rooms', async (req, res) => {
  try {
    const db = await readDB();
    const { checkIn, checkOut, guests } = req.query;
    
    let availableRooms = db.rooms.filter(room => room.available);
    
    if (guests) {
      availableRooms = availableRooms.filter(room => room.maxGuests >= parseInt(guests));
    }
    
    // Check for existing bookings in the date range
    if (checkIn && checkOut) {
      const requestedCheckIn = new Date(checkIn);
      const requestedCheckOut = new Date(checkOut);
      
      const conflictingBookings = db.bookings.filter(booking => {
        const bookingCheckIn = new Date(booking.checkIn);
        const bookingCheckOut = new Date(booking.checkOut);
        
        return (requestedCheckIn < bookingCheckOut && requestedCheckOut > bookingCheckIn);
      });
      
      const bookedRoomIds = conflictingBookings.map(booking => booking.roomId);
      availableRooms = availableRooms.filter(room => !bookedRoomIds.includes(room.id));
    }
    
    res.json(availableRooms);
  } catch (error) {
    res.status(500).json({ error: 'Failed to fetch rooms' });
  }
});

// Get room categories
app.get('/api/room-categories', async (req, res) => {
  try {
    const db = await readDB();
    const categories = {};
    
    db.rooms.forEach(room => {
      if (!categories[room.category]) {
        categories[room.category] = {
          type: room.category,
          price: room.price,
          maxGuests: room.maxGuests,
          amenities: room.amenities,
          count: 0
        };
      }
      categories[room.category].count++;
    });
    
    res.json(Object.values(categories));
  } catch (error) {
    res.status(500).json({ error: 'Failed to fetch room categories' });
  }
});

// Create booking
app.post('/api/bookings', async (req, res) => {
  try {
    const db = await readDB();
    const booking = {
      id: Date.now(),
      ...req.body,
      createdAt: new Date().toISOString()
    };
    
    // Check if room is available
    const room = db.rooms.find(r => r.id === booking.roomId);
    if (!room || !room.available) {
      return res.status(400).json({ error: 'Room not available' });
    }
    
    // Check for date conflicts
    const conflictingBooking = db.bookings.find(b => 
      b.roomId === booking.roomId &&
      new Date(booking.checkIn) < new Date(b.checkOut) &&
      new Date(booking.checkOut) > new Date(b.checkIn)
    );
    
    if (conflictingBooking) {
      return res.status(400).json({ error: 'Room already booked for selected dates' });
    }
    
    db.bookings.push(booking);
    await writeDB(db);
    
    res.json({ success: true, booking });
  } catch (error) {
    res.status(500).json({ error: 'Failed to create booking' });
  }
});

// Get all bookings
app.get('/api/bookings', async (req, res) => {
  try {
    const db = await readDB();
    res.json(db.bookings);
  } catch (error) {
    res.status(500).json({ error: 'Failed to fetch bookings' });
  }
});

app.listen(PORT, () => {
  console.log(`Hotel API server running on port ${PORT}`);
});