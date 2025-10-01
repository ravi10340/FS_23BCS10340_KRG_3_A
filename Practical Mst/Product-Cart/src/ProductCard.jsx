import React from 'react';

function ProductCard({ name, price, description, inStock }) {
  const formattedPrice = new Intl.NumberFormat('en-IN', {
    style: 'currency',
    currency: 'INR',
    minimumFractionDigits: 0,
  }).format(price);

  return (
    <div className="border p-4 m-2 w-60 text-center">
      <h3 className="text-lg font-semibold mb-2">{name}</h3>
      <p className="font-bold mb-2 text-blue-600">{formattedPrice}</p>
      <p className="text-sm mb-3">{description}</p>
      {inStock ? (
        <button className="bg-green-600 text-white px-4 py-2">Buy Now</button>
      ) : (
        <button className="bg-red-600 text-white px-4 py-2">Out of Stock</button>
      )}
    </div>
  );
}

export default ProductCard;
 