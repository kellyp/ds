package com.kelly.hystrix;

import com.kelly.Product;
import com.kelly.dao.ProductDao;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;


public class ProductGetCommand extends HystrixCommand<Product> {
    private final String id;

    public ProductGetCommand(String id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ProductGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(true)));
        this.id = id;
    }

    @Override
    protected Product run() throws Exception {
        Product product = ProductDao.getProductDao().get(id);
        return product;
    }
}
