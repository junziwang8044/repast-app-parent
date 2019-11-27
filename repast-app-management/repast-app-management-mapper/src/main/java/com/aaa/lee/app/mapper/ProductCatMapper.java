package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.ProductCat;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductCatMapper extends Mapper<ProductCat> {
    List<ProductCat> getCateByShopId(Long shopId);
}