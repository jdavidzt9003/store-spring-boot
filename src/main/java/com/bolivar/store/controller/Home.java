package com.bolivar.store.controller;

import com.bolivar.store.entities.Product;
import com.bolivar.store.repositories.ProductRepository;
import com.bolivar.store.services.IProductService;
import com.bolivar.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @Autowired
    IProductService productService;
    @GetMapping(path = "/")
    public String hello() {
        return "Hello";
    }

    @GetMapping(path = "/product/{id}")
    public Product getProductById(@PathVariable int id) {

        return productService.getProductById(id);
    }
}
