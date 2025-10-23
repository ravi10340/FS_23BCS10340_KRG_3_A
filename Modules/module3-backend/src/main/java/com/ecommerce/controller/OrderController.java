package com.ecommerce.controller;

import com.ecommerce.entity.Order;
import com.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4000"})
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }

    @PostMapping
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @Valid @RequestBody Order order) {
        if (!orderService.getOrderById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        order.setId(id);
        return ResponseEntity.ok(orderService.saveOrder(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (!orderService.getOrderById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
