package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductPic;
import com.aaa.lee.app.vo.CanTeenDateVo;
import com.aaa.lee.app.vo.ProductParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductMapper extends Mapper<Product> {

    List<Product> getProductByShopId(Long shopId);

    List<Product> selectAllHotProduct(Long shopId);

    List<Product> getLikePro(Long id);

    List<Product> getRecommandByShopId(Long shopId);

    List<ProductPic> selectPicByShopId(Long id);

    List<ProductParam> selectProductParam(Long id);

    List<ProductPic> selectAlbumByProductId(Long id);

    List<CanTeenDateVo> getCanteenDateByShopId(Long shopId);

}