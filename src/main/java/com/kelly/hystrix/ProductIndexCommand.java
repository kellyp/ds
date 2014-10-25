package com.kelly.hystrix;

import com.kelly.Product;
import com.kelly.dao.ProductDao;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.List;


public class ProductIndexCommand extends HystrixCommand<List<Product>> {

    public ProductIndexCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("ProductGroup"));
    }

    @Override
    protected List<Product> run() throws Exception {
        return ProductDao.getProductDao().index();
    }
}
