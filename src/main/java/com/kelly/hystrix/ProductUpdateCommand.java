package com.kelly.hystrix;

import com.kelly.Product;
import com.kelly.dao.ProductDao;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;


public class ProductUpdateCommand extends HystrixCommand<Product> {
    private final String id;
    private final Product product;

    public ProductUpdateCommand(String id, Product product) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ProductGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(true)));
        this.id = id;
        this.product = product;
    }

    @Override
    protected Product run() throws Exception {
        Product product = ProductDao.getProductDao().update(id, this.product);
        return product;
    }
}
