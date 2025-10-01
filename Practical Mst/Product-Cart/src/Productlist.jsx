import React from 'react';
import ProductCard from "./ProductCard.jsx";

function ProductList() {
  return (
    <div className="flex flex-wrap justify-center p-6">
      <ProductCard
        name="Smartphone Pro X"
        price={59999}
        description="Latest smartphone with OLED display."
        inStock={true}
      />
      <ProductCard
        name="Laptop Ultra 15"
        price={124999}
        description="Powerful laptop with 16GB RAM and 512GB SSD."
        inStock={false}
      />
      <ProductCard
        name="Bluetooth Speaker Mini"
        price={2999}
        description="Compact speaker with clear sound."
        inStock={true}
      />
    </div>
  );
}

export default ProductList;
