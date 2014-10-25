package com.kelly.dao;


import com.kelly.Product;

import java.util.List;

abstract public class ProductDao {

    private static ProductDao productDao;

    protected ProductDao(){

    }

    public static ProductDao getProductDao(){
        if(productDao == null){
            productDao = new ProductDaoMockImpl();
        }

        return productDao;
    }

    abstract public List<Product> index();
    abstract public Product create(Product product);
    abstract public Product get(String id);
    abstract public Product update(String id, Product product);
    abstract public boolean delete(String id);
}
