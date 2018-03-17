package com.vanhack.skip.product.controller;

import com.vanhack.skip.product.model.Product;
import com.vanhack.skip.product.repository.ProductRepository;
import com.vanhack.skip.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;






@Controller
@RequestMapping("/api/v1/Product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public Product getProductFromCustomer() {
        return service.getProductFromCustomer();
    }



}
