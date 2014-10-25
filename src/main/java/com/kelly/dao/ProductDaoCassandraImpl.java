package com.kelly.dao;


import com.kelly.Product;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import java.util.List;

public class ProductDaoCassandraImpl extends ProductDao{
    private final Session session;

    public ProductDaoCassandraImpl(){
        Cluster cluster = Cluster.builder()
                .addContactPoint("127.0.0.1").build();

        session = cluster.newSession();
    }

    @Override
    public List<Product> index() {
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product get(String id) {
        return null;
    }

    @Override
    public Product update(String id, Product product) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
