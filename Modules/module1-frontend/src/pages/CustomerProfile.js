import React from 'react';
import Login from '../components/Login';

function CustomerProfile() {
  return (
    <div className="container mx-auto p-4">
      <h1 className="text-3xl font-bold mb-6">Customer Profile</h1>
      <Login />
    </div>
  );
}

export default CustomerProfile;
