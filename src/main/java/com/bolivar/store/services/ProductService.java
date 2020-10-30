package com.bolivar.store.services;

import com.bolivar.store.entities.Product;
import com.bolivar.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository repo;
    public Product getProductById(int id) {
       return repo.getProduct(id);
    }
}
