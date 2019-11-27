package com.aaa.lee.app.service;


import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.ProductCatG;
import com.aaa.lee.app.mapper.ProductCatGMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class ProductCatGService extends BaseService<ProductCatG> {

    @Autowired
    private ProductCatGMapper ProductCatGMapper;
    @Override
    public Mapper<ProductCatG> getMapper() {
        return ProductCatGMapper;
    }
}
