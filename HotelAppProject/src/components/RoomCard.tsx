import React from 'react';
import { motion } from 'framer-motion';
import { Users, Wifi, Car, Coffee, MapPin, Star } from 'lucide-react';
import { RoomCategory } from '../types';

interface RoomCardProps {
  room: RoomCategory;
  onBook: (room: RoomCategory) => void;
}

const RoomCard: React.FC<RoomCardProps> = ({ room, onBook }) => {
  const getImageUrl = (category: string) => {
    switch (category) {
      case 'Standard':
        return 'https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&w=800&h=600&fit=crop';
      case 'Deluxe':
        return 'https://images.pexels.com/photos/1743229/pexels-photo-1743229.jpeg?auto=compress&cs=tinysrgb&w=800&h=600&fit=crop';
      case 'Suite':
        return 'https://images.pexels.com/photos/1457842/pexels-photo-1457842.jpeg?auto=compress&cs=tinysrgb&w=800&h=600&fit=crop';
      case 'Presidential':
        return 'https://images.pexels.com/photos/2598638/pexels-photo-2598638.jpeg?auto=compress&cs=tinysrgb&w=800&h=600&fit=crop';
      default:
        return 'https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&w=800&h=600&fit=crop';
    }
  };

  return (
    <motion.div
      initial={{ opacity: 0, y: 50 }}
      animate={{ opacity: 1, y: 0 }}
      whileHover={{ y: -5, scale: 1.02 }}
      className="bg-white rounded-xl shadow-lg overflow-hidden border border-gray-200 hover:shadow-2xl transition-all duration-300"
    >
      <div className="relative">
        <img
          src={getImageUrl(room.type)}
          alt={room.type}
          className="w-full h-48 object-cover"
        />
        <div className="absolute top-4 left-4">
          <span className="bg-blue-600 text-white px-3 py-1 rounded-full text-sm font-medium">
            {room.count} Available
          </span>
        </div>
        <div className="absolute top-4 right-4 flex items-center space-x-1 bg-white bg-opacity-90 px-2 py-1 rounded-full">
          <Star className="h-4 w-4 text-yellow-500 fill-current" />
          <span className="text-sm font-medium">4.8</span>
        </div>
      </div>

      <div className="p-6">
        <div className="flex justify-between items-start mb-3">
          <div>
            <h3 className="text-xl font-bold text-gray-800 mb-1">{room.type} Room</h3>
            <div className="flex items-center text-gray-600 text-sm">
              <MapPin className="h-4 w-4 mr-1" />
              <span>Downtown District</span>
            </div>
          </div>
          <div className="text-right">
            <div className="text-2xl font-bold text-blue-600">${room.price}</div>
            <div className="text-sm text-gray-500">per night</div>
          </div>
        </div>

        <div className="flex items-center mb-4">
          <Users className="h-4 w-4 text-gray-500 mr-2" />
          <span className="text-sm text-gray-600">Up to {room.maxGuests} guests</span>
        </div>

        <div className="mb-6">
          <h4 className="font-medium text-gray-800 mb-2">Amenities</h4>
          <div className="grid grid-cols-2 gap-2">
            {room.amenities.slice(0, 6).map((amenity, index) => (
              <div key={index} className="flex items-center text-sm text-gray-600">
                <div className="w-2 h-2 bg-blue-500 rounded-full mr-2"></div>
                {amenity}
              </div>
            ))}
          </div>
          {room.amenities.length > 6 && (
            <div className="text-sm text-blue-600 mt-2">
              +{room.amenities.length - 6} more amenities
            </div>
          )}
        </div>

        <div className="flex space-x-3">
          <motion.button
            whileHover={{ scale: 1.05 }}
            whileTap={{ scale: 0.95 }}
            className="flex-1 bg-gray-100 text-gray-800 py-3 px-4 rounded-lg hover:bg-gray-200 transition-colors font-medium"
          >
            View Details
          </motion.button>
          <motion.button
            whileHover={{ scale: 1.05 }}
            whileTap={{ scale: 0.95 }}
            onClick={() => onBook(room)}
            className="flex-1 bg-blue-600 text-white py-3 px-4 rounded-lg hover:bg-blue-700 transition-colors font-medium"
          >
            Book Now
          </motion.button>
        </div>
      </div>
    </motion.div>
  );
};

export default RoomCard;