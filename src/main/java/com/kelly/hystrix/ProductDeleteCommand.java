package com.kelly.hystrix;

import com.kelly.Product;
import com.kelly.dao.ProductDao;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;


public class ProductDeleteCommand extends HystrixCommand<Boolean> {
    private final String id;

    public ProductDeleteCommand(String id) {
        super(HystrixCommandGroupKey.Factory.asKey("ProductGroup"));
        this.id = id;
    }

    @Override
    protected Boolean run() throws Exception {
        ProductDao.getProductDao().delete(id);
        return ProductDao.getProductDao().delete(id);
    }
}
