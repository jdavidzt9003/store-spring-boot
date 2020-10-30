package com.bolivar.store.repositories;

import com.bolivar.store.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository {
    public Product getProduct(int id);
}