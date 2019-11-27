package com.aaa.lee.app.mapper;

import com.aaa.lee.app.vo.ProductHotBySale;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Author:RR
 * Description:
 * DATE：2019/11/21
 * PROJECTnNAME:repast-app-project
 */
public interface ProductHotBySaleMapper extends Mapper<ProductHotBySale> {
    List<ProductHotBySale> getHotProduct(Long shopId);
}
