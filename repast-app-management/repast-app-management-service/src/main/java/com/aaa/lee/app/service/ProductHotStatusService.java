package com.aaa.lee.app.service;


import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.ProductHotBySaleMapper;
import com.aaa.lee.app.vo.ProductHotBySale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Author:RR
 * Description:
 * DATE：2019/11/21
 * PROJECTnNAME:repast-app-project
 */
@Service
public class ProductHotStatusService extends BaseService<ProductHotBySale> {
    @Autowired
    private ProductHotBySaleMapper productHotBySaleMapper;

    @Override
    public Mapper<ProductHotBySale> getMapper() {
        return productHotBySaleMapper;
    }
    public List<ProductHotBySale> getHotProduct(Long shopId){
        List<ProductHotBySale> hotProduct = productHotBySaleMapper.getHotProduct(shopId);
        if(null!=hotProduct){
            return hotProduct;
        }
        return null;
    }
}
