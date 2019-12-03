package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductCategory;
import com.aaa.lee.app.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @作者：王君君
 * @项目：repast-app-parent
 * @包：com.aaa.lee.app.service
 * @日期：2019-11-22 11:37
 */
@Service
public class HotProductService extends BaseService<Product> {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Mapper<Product> getMapper() {
        return productMapper;
    }

    /**
     * 前台进入店铺通过店铺id获取热卖商品信息
     * @return
     */
    public List<Product> getHotProduct(Long shopId,String token){

        boolean b = selectToken(token);
        if (b){
            List<Product> hotProducts = productMapper.selectAllHotProduct(shopId);
            if (hotProducts.size()>0){
                return hotProducts;
            }
        }
        return null;
    }

}
