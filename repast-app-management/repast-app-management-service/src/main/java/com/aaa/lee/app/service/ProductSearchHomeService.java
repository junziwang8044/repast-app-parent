package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.mapper.ProductSearchHomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author 李永杰
 * @Date 2019/11/22 16:46
 **/
@Service
public class ProductSearchHomeService extends BaseService<Product> {

    @Autowired
    private ProductSearchHomeMapper productSearchHomeMapper;
    @Override
    public Mapper<Product> getMapper() {
        return productSearchHomeMapper;
    }

    public List<Product> getSearchHome(String name){
        List<Product> products = productSearchHomeMapper.selectProductSearchHome(name);
        if(products.size()>0){
            return products;
        }
        return null;
    }
}
