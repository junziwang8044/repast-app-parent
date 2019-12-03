package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductCategory;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @作者：王君君
 * @项目：repast-app-parent
 * @包：com.aaa.lee.app.controller
 * @日期：2019-11-22 10:53
 */
@RestController
@Api(value = "热卖商品", tags = "热卖商品信息接口")
public class HotProductController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 前台进入店铺通过店铺id获取热卖商品信息
     * @return
     */
    @GetMapping("/getHot")
    @ApiOperation(value = "热卖商品信息", notes = "通过店铺id获取热卖商品信息")
    public ResultData getHotProduct(Long shopId ,String token){
        List<Product> hotProduct = repastService.getHotProduct(shopId ,token);
        if (null != hotProduct){
            return success(hotProduct);
        }
        return failed();
    }

    /**
     * 通过商品id获取商品属性列表
     * @return
     */
    @GetMapping("/getPac")
    @ApiOperation(value = "商品属性", notes = "通过商品id获取商品属性列表")
    public ResultData getPacByProductId(Long shopId){
        List<ProductCategory> pacByProductId = repastService.getPacByProductId(shopId);
        if (pacByProductId.size()>0){
            return success(pacByProductId);
        }
        return null;
    }

}
