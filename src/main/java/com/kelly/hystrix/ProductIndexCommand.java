package com.kelly.hystrix;

import com.kelly.Product;
import com.kelly.dao.ProductDao;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.List;


public class ProductIndexCommand extends HystrixCommand<List<Product>> {

    public ProductIndexCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ProductGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerEnabled(true)));
    }

    @Override
    protected List<Product> run() throws Exception {
        return ProductDao.getProductDao().index();
    }
}
