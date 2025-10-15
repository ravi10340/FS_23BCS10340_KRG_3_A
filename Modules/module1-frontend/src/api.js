// API functions connected to backend

const API_BASE = 'http://localhost:8080/api';

export const fetchProducts = async () => {
  try {
    const response = await fetch(`${API_BASE}/products`);
    if (!response.ok) throw new Error('Failed to fetch products');
    return await response.json();
  } catch (error) {
    console.error(error);
    // Fallback to mock if backend not running
    return [
      { id: 1, name: 'Product 1', price: 10, image: 'https://via.placeholder.com/150' },
      { id: 2, name: 'Product 2', price: 20, image: 'https://via.placeholder.com/150' },
      { id: 3, name: 'Product 3', price: 30, image: 'https://via.placeholder.com/150' },
    ];
  }
};

export const loginUser = async (email, password) => {
  // Mock login for now
  if (email && password) {
    return { success: true, message: 'Logged in successfully' };
  }
  return { success: false, message: 'Invalid credentials' };
};

export const createOrder = async (order) => {
  try {
    const response = await fetch(`${API_BASE}/orders`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(order),
    });
    if (!response.ok) throw new Error('Failed to create order');
    return await response.json();
  } catch (error) {
    console.error(error);
    return null;
  }
};
