package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Product;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductSearchHomeMapper extends Mapper<Product> {


    /**
     * 搜索全部商品
     * @param name
     * @return
     */
    List<Product> selectProductSearchHome(String name);
}