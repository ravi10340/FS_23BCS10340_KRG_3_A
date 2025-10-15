import React from 'react';

function ProductCard({ product, onAddToCart }) {
  return (
    <div className="bg-white p-4 rounded-lg shadow-md">
      <img src={product.image} alt={product.name} className="w-full h-48 object-cover rounded" />
      <h3 className="text-lg font-semibold mt-2">{product.name}</h3>
      <p className="text-gray-600">${product.price}</p>
      <button onClick={onAddToCart} className="mt-2 bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600">Add to Cart</button>
    </div>
  );
}

export default ProductCard;
