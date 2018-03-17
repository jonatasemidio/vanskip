package com.vanhack.skip.product.service;

import com.vanhack.skip.product.model.Product;
import com.vanhack.skip.product.repository.ProductRepository;
import org.springframework.stereotype.Service;




@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product getProductFromCustomer() {
        return repository.getProductFromCustomer();
    }
}
