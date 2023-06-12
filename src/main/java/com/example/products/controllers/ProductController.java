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
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") UUID id){
        var product = service.getById(id);
        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> postProduct(@RequestBody @Valid ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveProduct(product));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Object> alterProduct(@PathVariable(value = "id") UUID id,
                                       @RequestBody @Valid ProductDTO dto){
        Optional<Product> productOptional = service.getById(id);
        if(productOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
        var product = productOptional.get();
        BeanUtils.copyProperties(dto, product);
        return ResponseEntity.status(HttpStatus.OK).body(service.saveProduct(product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id){
        Optional<Product> productOptional = service.getById(id);
        if (productOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        service.deleteProduct(productOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }


}
