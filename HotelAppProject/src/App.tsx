import React, { useState, useEffect } from 'react';
import { motion } from 'framer-motion';
import Header from './components/Header';
import Hero from './components/Hero';
import SearchBar from './components/SearchBar';
import RoomCard from './components/RoomCard';
import BookingModal from './components/BookingModal';
import BookingConfirmation from './components/BookingConfirmation';
import { RoomCategory, SearchParams, Booking } from './types';

function App() {
  const [roomCategories, setRoomCategories] = useState<RoomCategory[]>([]);
  const [searchParams, setSearchParams] = useState<SearchParams>({
    destination: 'New York',
    checkIn: new Date().toISOString().split('T')[0],
    checkOut: new Date(Date.now() + 24 * 60 * 60 * 1000).toISOString().split('T')[0],
    guests: 1
  });
  const [selectedRoom, setSelectedRoom] = useState<RoomCategory | null>(null);
  const [isBookingModalOpen, setIsBookingModalOpen] = useState(false);
  const [confirmedBooking, setConfirmedBooking] = useState<Booking | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchRoomCategories();
  }, []);

  const fetchRoomCategories = async () => {
    try {
      const response = await fetch('http://localhost:3001/api/room-categories');
      const data = await response.json();
      setRoomCategories(data);
    } catch (error) {
      console.error('Error fetching room categories:', error);
      // Fallback data if API is not available
      setRoomCategories([
        {
          type: 'Standard',
          price: 120,
          maxGuests: 2,
          amenities: ['WiFi', 'Air Conditioning', 'TV', 'Private Bathroom'],
          count: 20
        },
        {
          type: 'Deluxe',
          price: 180,
          maxGuests: 3,
          amenities: ['WiFi', 'Air Conditioning', 'TV', 'Private Bathroom', 'Mini Bar', 'City View'],
          count: 15
        },
        {
          type: 'Suite',
          price: 280,
          maxGuests: 4,
          amenities: ['WiFi', 'Air Conditioning', 'TV', 'Private Bathroom', 'Mini Bar', 'Ocean View', 'Balcony'],
          count: 10
        },
        {
          type: 'Presidential',
          price: 450,
          maxGuests: 4,
          amenities: ['WiFi', 'Air Conditioning', 'TV', 'Private Bathroom', 'Mini Bar', 'Ocean View', 'Balcony', 'Jacuzzi', 'Butler Service'],
          count: 5
        }
      ]);
    } finally {
      setLoading(false);
    }
  };

  const handleSearch = (params: SearchParams) => {
    setSearchParams(params);
    // Filter rooms based on search criteria
    // In a real app, this would refetch data from the API
  };

  const handleBookRoom = (room: RoomCategory) => {
    setSelectedRoom(room);
    setIsBookingModalOpen(true);
  };

  const handleBookingComplete = (booking: Booking) => {
    setConfirmedBooking(booking);
    setIsBookingModalOpen(false);
    setSelectedRoom(null);
  };

  const filteredRooms = roomCategories.filter(room => room.maxGuests >= searchParams.guests);

  return (
    <div className="min-h-screen bg-gray-50">
      <Header />
      <Hero />
      
      <div className="container mx-auto">
        <SearchBar onSearch={handleSearch} />
        
        {/* Results Section */}
        <div className="px-4 py-12">
          <motion.div
            initial={{ opacity: 0, y: 20 }}
            animate={{ opacity: 1, y: 0 }}
            className="mb-8"
          >
            <h2 className="text-3xl font-bold text-gray-800 mb-2">
              Available Rooms in {searchParams.destination}
            </h2>
            <p className="text-gray-600">
              {searchParams.checkIn} - {searchParams.checkOut} • {searchParams.guests} guest{searchParams.guests > 1 ? 's' : ''}
            </p>
          </motion.div>

          {loading ? (
            <div className="flex items-center justify-center py-12">
              <div className="animate-spin rounded-full h-12 w-12 border-b-2 border-blue-600"></div>
            </div>
          ) : (
            <motion.div
              initial={{ opacity: 0 }}
              animate={{ opacity: 1 }}
              transition={{ delay: 0.2 }}
              className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6"
            >
              {filteredRooms.map((room, index) => (
                <motion.div
                  key={room.type}
                  initial={{ opacity: 0, y: 50 }}
                  animate={{ opacity: 1, y: 0 }}
                  transition={{ delay: index * 0.1 }}
                >
                  <RoomCard room={room} onBook={handleBookRoom} />
                </motion.div>
              ))}
            </motion.div>
          )}

          {filteredRooms.length === 0 && !loading && (
            <motion.div
              initial={{ opacity: 0 }}
              animate={{ opacity: 1 }}
              className="text-center py-12"
            >
              <p className="text-gray-600 text-lg">
                No rooms available for {searchParams.guests} guest{searchParams.guests > 1 ? 's' : ''}. 
                Try adjusting your search criteria.
              </p>
            </motion.div>
          )}
        </div>

        {/* Features Section */}
        <motion.div
          initial={{ opacity: 0, y: 50 }}
          whileInView={{ opacity: 1, y: 0 }}
          viewport={{ once: true }}
          className="px-4 py-16 bg-white"
        >
          <div className="text-center mb-12">
            <h2 className="text-3xl font-bold text-gray-800 mb-4">Why Choose LuxuryStay?</h2>
            <p className="text-gray-600 max-w-2xl mx-auto">
              Experience premium hospitality with world-class amenities and exceptional service
            </p>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
            {[
              {
                title: "Premium Locations",
                description: "Prime locations in the heart of the city with easy access to attractions",
                image: "https://images.pexels.com/photos/2291367/pexels-photo-2291367.jpeg?auto=compress&cs=tinysrgb&w=400&h=300&fit=crop"
              },
              {
                title: "Luxury Amenities",
                description: "State-of-the-art facilities including spa, fitness center, and fine dining",
                image: "https://images.pexels.com/photos/1134176/pexels-photo-1134176.jpeg?auto=compress&cs=tinysrgb&w=400&h=300&fit=crop"
              },
              {
                title: "Exceptional Service",
                description: "24/7 concierge service and personalized attention to every detail",
                image: "https://images.pexels.com/photos/6474/hands-people-woman-working.jpg?auto=compress&cs=tinysrgb&w=400&h=300&fit=crop"
              }
            ].map((feature, index) => (
              <motion.div
                key={index}
                initial={{ opacity: 0, y: 30 }}
                whileInView={{ opacity: 1, y: 0 }}
                viewport={{ once: true }}
                transition={{ delay: index * 0.2 }}
                whileHover={{ y: -5 }}
                className="text-center group"
              >
                <div className="overflow-hidden rounded-lg mb-4">
                  <img
                    src={feature.image}
                    alt={feature.title}
                    className="w-full h-48 object-cover group-hover:scale-110 transition-transform duration-300"
                  />
                </div>
                <h3 className="text-xl font-semibold text-gray-800 mb-2">{feature.title}</h3>
                <p className="text-gray-600">{feature.description}</p>
              </motion.div>
            ))}
          </div>
        </motion.div>
      </div>

      {/* Booking Modal */}
      <BookingModal
        isOpen={isBookingModalOpen}
        onClose={() => {
          setIsBookingModalOpen(false);
          setSelectedRoom(null);
        }}
        room={selectedRoom}
        onBookingComplete={handleBookingComplete}
        checkIn={searchParams.checkIn}
        checkOut={searchParams.checkOut}
        guests={searchParams.guests}
      />

      {/* Booking Confirmation */}
      {confirmedBooking && (
        <BookingConfirmation booking={confirmedBooking} />
      )}
    </div>
  );
}

export default App;