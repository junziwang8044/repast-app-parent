package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.ProductCategory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductCategoryMapper extends Mapper<ProductCategory> {

    List<ProductCategory> getPacByProductId(Long shopId);

}