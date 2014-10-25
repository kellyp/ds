package com.kelly.hystrix;

import com.kelly.Product;
import com.kelly.dao.ProductDao;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;


public class ProductCreateCommand extends HystrixCommand<Product> {
    private final Product product;

    public ProductCreateCommand(Product product) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ProductGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(true)));
        this.product = product;
    }

    @Override
    protected Product run() throws Exception {
        Product product = ProductDao.getProductDao().create(this.product);
        return product;
    }
}
