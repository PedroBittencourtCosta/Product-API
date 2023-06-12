package com.example.products.service;

import com.example.products.DTO.ProductDTO;
import com.example.products.model.Product;
import com.example.products.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public List<Product> getAll(){
        List<Product> products = repository.findAll();
        return products;
    }

    @Transactional
    public Optional<Product> getById(UUID id){
        Optional<Product> product = repository.findById(id);
        return product;
    }

    @Transactional
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    @Transactional
    public void deleteProduct(Product product){
        repository.delete(product);
    }

}
