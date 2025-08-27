import React from 'react';
import { motion } from 'framer-motion';
import { Hotel, Menu, User } from 'lucide-react';

const Header: React.FC = () => {
  return (
    <motion.header 
      initial={{ y: -100 }}
      animate={{ y: 0 }}
      className="bg-white shadow-lg border-b border-gray-200"
    >
      <div className="container mx-auto px-4 py-4">
        <div className="flex items-center justify-between">
          <motion.div 
            whileHover={{ scale: 1.05 }}
            className="flex items-center space-x-3"
          >
            <div className="bg-blue-600 p-2 rounded-lg">
              <Hotel className="h-8 w-8 text-white" />
            </div>
            <div>
              <h1 className="text-2xl font-bold text-gray-800">LuxuryStay</h1>
              <p className="text-sm text-gray-600">Premium Hotel Experience</p>
            </div>
          </motion.div>
          
          <div className="hidden md:flex items-center space-x-6">
            <nav className="flex space-x-6">
              <a href="#" className="text-gray-700 hover:text-blue-600 transition-colors">Stays</a>
              <a href="#" className="text-gray-700 hover:text-blue-600 transition-colors">Experiences</a>
              <a href="#" className="text-gray-700 hover:text-blue-600 transition-colors">About</a>
            </nav>
            <motion.button
              whileHover={{ scale: 1.05 }}
              whileTap={{ scale: 0.95 }}
              className="flex items-center space-x-2 bg-blue-600 text-white px-4 py-2 rounded-lg hover:bg-blue-700 transition-colors"
            >
              <User className="h-4 w-4" />
              <span>Sign In</span>
            </motion.button>
          </div>
          
          <button className="md:hidden">
            <Menu className="h-6 w-6 text-gray-700" />
          </button>
        </div>
      </div>
    </motion.header>
  );
};

export default Header;