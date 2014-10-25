package com.kelly.dao;

import com.kelly.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ProductDaoMockImpl extends ProductDao {
    private HashMap<String, Product> mockDB;

    protected ProductDaoMockImpl(){
        mockDB = new LinkedHashMap<String, Product>();
    }

    @Override
    public List<Product> index() {
        return new ArrayList<Product>(mockDB.values());
    }

    @Override
    public Product create(Product product) {
        product.setId(String.valueOf(mockDB.keySet().size() + 1));
        mockDB.put(product.getId(), product);
        return product;
    }

    @Override
    public Product get(String id) {
        return mockDB.get(id);
    }

    @Override
    public Product update(String id, Product product) {
        mockDB.put(id, product);
        return product;
    }

    @Override
    public boolean delete(String id) {
        mockDB.remove(id);
        return true;
    }
}
