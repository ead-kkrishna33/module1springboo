package com.coding.module1introduction.controllers;

import com.coding.module1introduction.entities.ProductEntity;
import com.coding.module1introduction.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping
    public List<ProductEntity> findAllProducts(@RequestParam(defaultValue="id") String sortBy){
        return productRepository.findBy(Sort.by(Sort.Order.desc(sortBy)));

    }
}
