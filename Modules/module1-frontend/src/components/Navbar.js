import React from 'react';
import { Link } from 'react-router-dom';

function Navbar() {
  return (
    <nav className="bg-blue-600 p-4">
      <div className="container mx-auto flex justify-between items-center">
        <Link to="/" className="text-white text-xl font-bold">Module1 Frontend</Link>
        <div className="space-x-4">
          <Link to="/" className="text-white hover:text-gray-200">Home</Link>
          <Link to="/seller" className="text-white hover:text-gray-200">Seller Dashboard</Link>
          <Link to="/profile" className="text-white hover:text-gray-200">Profile</Link>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
