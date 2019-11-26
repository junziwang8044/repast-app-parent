package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.ProductCategory;
import com.aaa.lee.app.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @作者：王君君
 * @项目：repast-app-parent
 * @包：com.aaa.lee.app.service
 * @日期：2019-11-23 20:55
 */
@Service
public class PacByProductIdService extends BaseService<ProductCategory> {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public Mapper<ProductCategory> getMapper() {
        return productCategoryMapper;
    }

    public List<ProductCategory> getPacByProductId(Long shopId){
        List<ProductCategory> pacByProductId = productCategoryMapper.getPacByProductId(shopId);
        if (pacByProductId.size()>0){
            return pacByProductId;
        }
        return null;
    }
}
