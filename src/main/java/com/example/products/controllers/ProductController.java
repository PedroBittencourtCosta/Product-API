package com.example.products.controllers;

import com.example.products.DTO.ProductDTO;
import com.example.products.model.Product;
import com.example.products.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @PostMapping("/product")
    public ResponseEntity<Product> postProduct(@RequestBody @Valid ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postProduct(product));
    }


}
