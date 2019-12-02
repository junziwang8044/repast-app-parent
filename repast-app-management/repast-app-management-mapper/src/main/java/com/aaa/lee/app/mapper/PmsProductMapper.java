package com.aaa.lee.app.mapper;


import com.aaa.lee.app.domain.PmsProduct;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsProductMapper extends Mapper<PmsProduct> {



    /**
     *       通过id查询商品上架下架和删除为删除的商品状态
     **/
    List<PmsProduct> getSelectAll(Long brand_id);


}