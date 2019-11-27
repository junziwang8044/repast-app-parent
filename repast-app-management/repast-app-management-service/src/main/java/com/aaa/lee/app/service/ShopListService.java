package com.aaa.lee.app.service;


import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.ShopList;
import com.aaa.lee.app.mapper.ShopListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class ShopListService extends BaseService<ShopList> {
    @Autowired
    private ShopListMapper shopListMapper;

    @Override
    public Mapper<ShopList> getMapper() {

        return shopListMapper;
    }

    /**
     * 获取所有商品信息
     * @return
     */
    public List<ShopList> getShopList(){
        System.out.println(324);
        List<ShopList> shopList = shopListMapper.getShopList();
        if(shopList.size()>0){
            return shopList;
        }
        return null;
    }
}
