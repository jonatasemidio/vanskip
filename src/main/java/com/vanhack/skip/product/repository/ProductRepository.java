package com.vanhack.skip.product.repository;

import com.vanhack.skip.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository {
    private static List<Product> db;

    public ProductRepository() {
        db = new ArrayList<>();
    }

    public Product getProductFromCustomer() {
        return new Product(1);
    }
}
