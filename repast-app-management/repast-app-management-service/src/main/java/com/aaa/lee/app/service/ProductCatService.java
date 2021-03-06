package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.ProductCat;
import com.aaa.lee.app.mapper.ProductCatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 11:43
 * @Description
 **/
@Service
public class ProductCatService extends BaseService<ProductCat> {

    @Autowired
    private ProductCatMapper productCatMapper;

    @Override
    public Mapper<ProductCat> getMapper() {
        return productCatMapper;
    }

    /**
     * 店铺内的商品列
     * @param shopId
     * @return
     */
    public List<ProductCat> getCateByShopId(Long shopId,String token){
        boolean boo = selectToken(token);
        if (boo) {
            List<ProductCat> productCats = productCatMapper.getCateByShopId(shopId);
            if (productCats.size() > 0) {
                return productCats;
            }
        }
        return null;
    }
}
