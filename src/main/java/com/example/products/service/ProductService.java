package com.example.products.service;

import com.example.products.DTO.ProductDTO;
import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAll(){
        List<Product> products = repository.findAll();
        return products;
    }

    @Transactional
    public Product postProduct(Product product){
        return repository.save(product);
    }
}
