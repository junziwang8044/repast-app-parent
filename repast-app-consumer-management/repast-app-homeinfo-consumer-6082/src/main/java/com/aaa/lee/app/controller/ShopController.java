package com.aaa.lee.app.controller;


import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.ProductCatG;
import com.aaa.lee.app.domain.ShopList;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "商家信息",tags="商家信息接口")
public class ShopController extends BaseController {

    @Autowired
    private IRepastService repastService;
    /**
     * 通商店id获取商品类目的列表
     * @param shopid
     * @return
     */
    @GetMapping("/getCatByShopId")
    @ApiOperation(value = "商品类目", notes = "通过店铺主键查询商品类目列表")
    public ResultData getCategoryByShopId(Long shopid){
        List<ProductCatG> catList = repastService.getCategoryByShopId1(shopid);
        if(null!=catList){
            return  success(catList);
        }

        return failed();
    }
    /**
     * 查询出所有的店铺信息
     */
    @GetMapping("/getShopList")
    @ApiOperation(value = "所有店铺信息",notes="查询出所有店铺信息")
    public ResultData getShopList(){
        List<ShopList> shopList = repastService.getShopList();
        System.out.println(shopList);
        if(null!=shopList){
            return success(shopList);
        }
        return failed();
    }
}
