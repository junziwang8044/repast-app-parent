package com.aaa.lee.app.mapper;


import com.aaa.lee.app.domain.ProductCatG;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductCatGMapper extends Mapper<ProductCatG> {
    List<ProductCatG> getProductCat(Long shopid);
}