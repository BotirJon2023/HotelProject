export interface Room {
  id: number;
  number: string;
  category: string;
  price: number;
  maxGuests: number;
  amenities: string[];
  available: boolean;
}

export interface RoomCategory {
  type: string;
  price: number;
  maxGuests: number;
  amenities: string[];
  count: number;
}

export interface Booking {
  id?: number;
  roomId: number;
  guestName: string;
  guestEmail: string;
  guestPhone: string;
  checkIn: string;
  checkOut: string;
  guests: number;
  breakfast: boolean;
  garage: boolean;
  totalPrice: number;
  createdAt?: string;
}

export interface SearchParams {
  checkIn: string;
  checkOut: string;
  guests: number;
  destination: string;
}