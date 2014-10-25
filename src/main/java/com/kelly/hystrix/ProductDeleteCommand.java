package com.kelly.hystrix;

import com.kelly.Product;
import com.kelly.dao.ProductDao;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;


public class ProductDeleteCommand extends HystrixCommand<Boolean> {
    private final String id;

    public ProductDeleteCommand(String id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ProductGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(true)));
        this.id = id;
    }

    @Override
    protected Boolean run() throws Exception {
        ProductDao.getProductDao().delete(id);
        return ProductDao.getProductDao().delete(id);
    }
}
