package com.aaa.lee.app.mapper;

;
import com.aaa.lee.app.domain.ShopList;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

;

public interface ShopListMapper extends Mapper<ShopList> {
    /**
     * 查询所有店铺的信息
     */
    List<ShopList> getShopList();
}