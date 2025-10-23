package com.ecommerce.controller;

import com.ecommerce.entity.Seller;
import com.ecommerce.service.SellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4000"})
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Long id) {
        return sellerService.getSellerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Seller createSeller(@Valid @RequestBody Seller seller) {
        return sellerService.saveSeller(seller);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @Valid @RequestBody Seller seller) {
        if (!sellerService.getSellerById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        seller.setId(id);
        return ResponseEntity.ok(sellerService.saveSeller(seller));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        if (!sellerService.getSellerById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        sellerService.deleteSeller(id);
        return ResponseEntity.noContent().build();
    }
}
