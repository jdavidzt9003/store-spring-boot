package com.bolivar.store.services;

import com.bolivar.store.entities.Product;
import org.springframework.stereotype.Service;


public interface IProductService {
    public Product getProductById(int id);
}
