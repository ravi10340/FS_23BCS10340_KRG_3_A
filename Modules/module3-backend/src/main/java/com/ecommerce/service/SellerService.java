package com.ecommerce.service;

import com.ecommerce.entity.Seller;
import com.ecommerce.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Optional<Seller> getSellerById(Long id) {
        return sellerRepository.findById(id);
    }

    public Optional<Seller> getSellerByEmail(String email) {
        return sellerRepository.findByEmail(email);
    }

    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }
}
