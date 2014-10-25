package com.kelly.hystrix;

import com.kelly.Product;
import com.kelly.dao.ProductDao;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;


public class ProductGetCommand extends HystrixCommand<Product> {
    private final String id;

    public ProductGetCommand(String id) {
        super(HystrixCommandGroupKey.Factory.asKey("ProductGroup"));
        this.id = id;
    }

    @Override
    protected Product run() throws Exception {
        Product product = ProductDao.getProductDao().get(id);
        return product;
    }
}
