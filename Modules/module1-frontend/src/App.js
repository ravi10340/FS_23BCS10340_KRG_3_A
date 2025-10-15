import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './pages/Home';
import SellerDashboard from './pages/SellerDashboard';
import CustomerProfile from './pages/CustomerProfile';

function App() {
  return (
    <Router>
      <div className="min-h-screen bg-gray-100">
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/seller" element={<SellerDashboard />} />
          <Route path="/profile" element={<CustomerProfile />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
