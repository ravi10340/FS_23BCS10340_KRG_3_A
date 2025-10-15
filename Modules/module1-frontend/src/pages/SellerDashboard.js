import React from 'react';

function SellerDashboard() {
  return (
    <div className="container mx-auto p-4">
      <h1 className="text-3xl font-bold mb-6">Seller Dashboard</h1>
      <p>Welcome to your seller dashboard. Here you can manage your products.</p>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        <div className="bg-white p-4 rounded-lg shadow-md">
          <h2 className="text-xl font-semibold">Sales Overview</h2>
          <p>Total Sales: $1000</p>
        </div>
        <div className="bg-white p-4 rounded-lg shadow-md">
          <h2 className="text-xl font-semibold">Products</h2>
          <p>Active Products: 5</p>
        </div>
      </div>
    </div>
  );
}

export default SellerDashboard;
