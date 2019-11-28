package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.ShopInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ShopInfoMapper extends Mapper<ShopInfo> {

    ShopInfo getShopInfoByShopId(Long shopId);

    List<ShopInfo> touchShopByShopId(Long shopId);

}