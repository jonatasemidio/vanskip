package com.vanhack.skip.customer.repository;

import com.vanhack.skip.customer.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private static List<Customer> db;

    public CustomerRepository() {
        db = new ArrayList<>();
    }

    public void save(Customer customer) {
        db.add(customer);

    }

    public Optional<Customer> findByUsername(String username) {
        return db.stream().filter(customer -> username.equals(customer.getUsername())).findFirst();
    }
}
