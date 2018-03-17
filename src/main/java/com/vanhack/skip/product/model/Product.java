package com.vanhack.skip.product.model;

public class Product {
    private Integer id;
    private Integer storeId;
    private String name;
    private String description;

    public Product() {}

    public Product(Integer id) {
        this(id, null, null, null);
    }

    public Product(Integer id, Integer storeId, String name, String description) {
        this.id = id;
        this.storeId = storeId;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
