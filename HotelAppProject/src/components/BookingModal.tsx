import React, { useState } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { X, User, Mail, Phone, Calendar, Users, Coffee, Car, CreditCard } from 'lucide-react';
import { RoomCategory, Booking } from '../types';

interface BookingModalProps {
  isOpen: boolean;
  onClose: () => void;
  room: RoomCategory | null;
  onBookingComplete: (booking: Booking) => void;
  checkIn: string;
  checkOut: string;
  guests: number;
}

const BookingModal: React.FC<BookingModalProps> = ({
  isOpen,
  onClose,
  room,
  onBookingComplete,
  checkIn,
  checkOut,
  guests
}) => {
  const [formData, setFormData] = useState({
    guestName: '',
    guestEmail: '',
    guestPhone: '',
    breakfast: false,
    garage: false
  });

  const [step, setStep] = useState(1);

  if (!room) return null;

  const nightsCount = Math.ceil((new Date(checkOut).getTime() - new Date(checkIn).getTime()) / (1000 * 60 * 60 * 24));
  const roomPrice = room.price * nightsCount;
  const breakfastPrice = formData.breakfast ? 25 * guests * nightsCount : 0;
  const garagePrice = formData.garage ? 15 * nightsCount : 0;
  const totalPrice = roomPrice + breakfastPrice + garagePrice;

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    
    const booking: Booking = {
      roomId: Math.floor(Math.random() * 50) + 1, // Random room assignment for demo
      guestName: formData.guestName,
      guestEmail: formData.guestEmail,
      guestPhone: formData.guestPhone,
      checkIn,
      checkOut,
      guests,
      breakfast: formData.breakfast,
      garage: formData.garage,
      totalPrice
    };

    try {
      const response = await fetch('http://localhost:3001/api/bookings', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(booking),
      });

      if (response.ok) {
        const result = await response.json();
        onBookingComplete(result.booking);
        onClose();
        setStep(1);
        setFormData({ guestName: '', guestEmail: '', guestPhone: '', breakfast: false, garage: false });
      }
    } catch (error) {
      console.error('Booking error:', error);
    }
  };

  return (
    <AnimatePresence>
      {isOpen && (
        <motion.div
          initial={{ opacity: 0 }}
          animate={{ opacity: 1 }}
          exit={{ opacity: 0 }}
          className="fixed inset-0 bg-black bg-opacity-50 z-50 flex items-center justify-center p-4"
        >
          <motion.div
            initial={{ scale: 0.7, opacity: 0 }}
            animate={{ scale: 1, opacity: 1 }}
            exit={{ scale: 0.7, opacity: 0 }}
            className="bg-white rounded-2xl max-w-2xl w-full max-h-[90vh] overflow-auto"
          >
            {/* Header */}
            <div className="flex items-center justify-between p-6 border-b">
              <h2 className="text-2xl font-bold text-gray-800">Book Your Stay</h2>
              <button
                onClick={onClose}
                className="p-2 hover:bg-gray-100 rounded-full transition-colors"
              >
                <X className="h-6 w-6" />
              </button>
            </div>

            {/* Progress Steps */}
            <div className="flex items-center justify-center p-4 bg-gray-50">
              <div className="flex space-x-4">
                <div className={`flex items-center ${step >= 1 ? 'text-blue-600' : 'text-gray-400'}`}>
                  <div className={`w-8 h-8 rounded-full flex items-center justify-center ${step >= 1 ? 'bg-blue-600 text-white' : 'bg-gray-300'}`}>
                    1
                  </div>
                  <span className="ml-2 hidden sm:block">Details</span>
                </div>
                <div className="w-16 h-0.5 bg-gray-300 mt-4"></div>
                <div className={`flex items-center ${step >= 2 ? 'text-blue-600' : 'text-gray-400'}`}>
                  <div className={`w-8 h-8 rounded-full flex items-center justify-center ${step >= 2 ? 'bg-blue-600 text-white' : 'bg-gray-300'}`}>
                    2
                  </div>
                  <span className="ml-2 hidden sm:block">Payment</span>
                </div>
              </div>
            </div>

            <form onSubmit={handleSubmit} className="p-6">
              {step === 1 && (
                <motion.div
                  initial={{ opacity: 0, x: 20 }}
                  animate={{ opacity: 1, x: 0 }}
                  className="space-y-6"
                >
                  {/* Room Summary */}
                  <div className="bg-blue-50 p-4 rounded-lg">
                    <h3 className="font-bold text-lg text-blue-800 mb-2">{room.type} Room</h3>
                    <div className="grid grid-cols-2 gap-4 text-sm">
                      <div className="flex items-center">
                        <Calendar className="h-4 w-4 text-blue-600 mr-2" />
                        <span>{checkIn} - {checkOut}</span>
                      </div>
                      <div className="flex items-center">
                        <Users className="h-4 w-4 text-blue-600 mr-2" />
                        <span>{guests} guests</span>
                      </div>
                      <div className="col-span-2 text-right">
                        <span className="text-lg font-bold text-blue-600">${room.price} × {nightsCount} nights</span>
                      </div>
                    </div>
                  </div>

                  {/* Guest Information */}
                  <div className="space-y-4">
                    <h3 className="text-lg font-semibold text-gray-800">Guest Information</h3>
                    
                    <div className="relative">
                      <User className="absolute left-3 top-3 h-5 w-5 text-gray-400" />
                      <input
                        type="text"
                        required
                        placeholder="Full Name"
                        value={formData.guestName}
                        onChange={(e) => setFormData({ ...formData, guestName: e.target.value })}
                        className="w-full pl-10 pr-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                      />
                    </div>

                    <div className="relative">
                      <Mail className="absolute left-3 top-3 h-5 w-5 text-gray-400" />
                      <input
                        type="email"
                        required
                        placeholder="Email Address"
                        value={formData.guestEmail}
                        onChange={(e) => setFormData({ ...formData, guestEmail: e.target.value })}
                        className="w-full pl-10 pr-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                      />
                    </div>

                    <div className="relative">
                      <Phone className="absolute left-3 top-3 h-5 w-5 text-gray-400" />
                      <input
                        type="tel"
                        required
                        placeholder="Phone Number"
                        value={formData.guestPhone}
                        onChange={(e) => setFormData({ ...formData, guestPhone: e.target.value })}
                        className="w-full pl-10 pr-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                      />
                    </div>
                  </div>

                  {/* Add-ons */}
                  <div className="space-y-4">
                    <h3 className="text-lg font-semibold text-gray-800">Add-ons</h3>
                    
                    <label className="flex items-center justify-between p-4 border border-gray-200 rounded-lg hover:bg-gray-50 cursor-pointer">
                      <div className="flex items-center">
                        <Coffee className="h-5 w-5 text-orange-500 mr-3" />
                        <div>
                          <div className="font-medium">Breakfast Included</div>
                          <div className="text-sm text-gray-500">Continental breakfast for all guests</div>
                        </div>
                      </div>
                      <div className="flex items-center">
                        <span className="mr-3 text-blue-600 font-medium">+${25 * guests}/night</span>
                        <input
                          type="checkbox"
                          checked={formData.breakfast}
                          onChange={(e) => setFormData({ ...formData, breakfast: e.target.checked })}
                          className="w-4 h-4 text-blue-600 border-gray-300 rounded focus:ring-blue-500"
                        />
                      </div>
                    </label>

                    <label className="flex items-center justify-between p-4 border border-gray-200 rounded-lg hover:bg-gray-50 cursor-pointer">
                      <div className="flex items-center">
                        <Car className="h-5 w-5 text-blue-500 mr-3" />
                        <div>
                          <div className="font-medium">Parking Garage</div>
                          <div className="text-sm text-gray-500">Secure underground parking</div>
                        </div>
                      </div>
                      <div className="flex items-center">
                        <span className="mr-3 text-blue-600 font-medium">+$15/night</span>
                        <input
                          type="checkbox"
                          checked={formData.garage}
                          onChange={(e) => setFormData({ ...formData, garage: e.target.checked })}
                          className="w-4 h-4 text-blue-600 border-gray-300 rounded focus:ring-blue-500"
                        />
                      </div>
                    </label>
                  </div>

                  <motion.button
                    whileHover={{ scale: 1.02 }}
                    whileTap={{ scale: 0.98 }}
                    type="button"
                    onClick={() => setStep(2)}
                    className="w-full bg-blue-600 text-white py-3 px-6 rounded-lg hover:bg-blue-700 transition-colors font-medium"
                  >
                    Continue to Payment
                  </motion.button>
                </motion.div>
              )}

              {step === 2 && (
                <motion.div
                  initial={{ opacity: 0, x: 20 }}
                  animate={{ opacity: 1, x: 0 }}
                  className="space-y-6"
                >
                  {/* Booking Summary */}
                  <div className="bg-gray-50 p-4 rounded-lg">
                    <h3 className="font-bold text-lg text-gray-800 mb-4">Booking Summary</h3>
                    <div className="space-y-2">
                      <div className="flex justify-between">
                        <span>{room.type} Room × {nightsCount} nights</span>
                        <span>${roomPrice}</span>
                      </div>
                      {formData.breakfast && (
                        <div className="flex justify-between">
                          <span>Breakfast × {guests} guests × {nightsCount} nights</span>
                          <span>${breakfastPrice}</span>
                        </div>
                      )}
                      {formData.garage && (
                        <div className="flex justify-between">
                          <span>Parking × {nightsCount} nights</span>
                          <span>${garagePrice}</span>
                        </div>
                      )}
                      <hr className="my-2" />
                      <div className="flex justify-between text-lg font-bold">
                        <span>Total</span>
                        <span>${totalPrice}</span>
                      </div>
                    </div>
                  </div>

                  {/* Payment Form */}
                  <div className="space-y-4">
                    <h3 className="text-lg font-semibold text-gray-800">Payment Information</h3>
                    
                    <div className="relative">
                      <CreditCard className="absolute left-3 top-3 h-5 w-5 text-gray-400" />
                      <input
                        type="text"
                        placeholder="Card Number"
                        className="w-full pl-10 pr-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                      />
                    </div>

                    <div className="grid grid-cols-2 gap-4">
                      <input
                        type="text"
                        placeholder="MM/YY"
                        className="px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                      />
                      <input
                        type="text"
                        placeholder="CVV"
                        className="px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                      />
                    </div>

                    <input
                      type="text"
                      placeholder="Cardholder Name"
                      className="w-full px-4 py-3 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                    />
                  </div>

                  <div className="flex space-x-4">
                    <motion.button
                      whileHover={{ scale: 1.02 }}
                      whileTap={{ scale: 0.98 }}
                      type="button"
                      onClick={() => setStep(1)}
                      className="flex-1 bg-gray-200 text-gray-800 py-3 px-6 rounded-lg hover:bg-gray-300 transition-colors font-medium"
                    >
                      Back
                    </motion.button>
                    <motion.button
                      whileHover={{ scale: 1.02 }}
                      whileTap={{ scale: 0.98 }}
                      type="submit"
                      className="flex-1 bg-green-600 text-white py-3 px-6 rounded-lg hover:bg-green-700 transition-colors font-medium"
                    >
                      Complete Booking
                    </motion.button>
                  </div>
                </motion.div>
              )}
            </form>
          </motion.div>
        </motion.div>
      )}
    </AnimatePresence>
  );
};

export default BookingModal;