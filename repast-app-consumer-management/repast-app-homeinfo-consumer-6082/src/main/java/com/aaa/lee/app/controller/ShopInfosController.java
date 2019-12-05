package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.ProductCat;
import com.aaa.lee.app.domain.ShopInfo;
import com.aaa.lee.app.domain.ShopInfoFacility;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 10:55
 * @Description
 *      商家controller
 **/
@RestController
@Api(value = "商家信息", tags = "商家信息接口")
public class ShopInfosController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * @author Seven Lee
     * @description
     *      通过主键查询店铺信息
     * @param [shopId]
     * @date 2019/11/21
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    @GetMapping("/getShopMsgById")
    @ApiOperation(value = "商店信息", notes = "通过主键查询商家信息")
    public ResultData getShopMsgById(@RequestParam("shopId")Long shopId,@RequestParam("token") String token) {
        ShopInfo shopList = repastService.getShopMsgById(shopId,token);
        if (null!=shopList){
            return success(shopList);
        }else{
            return failed();
        }
    }

    /**
     * 点击店铺获取店铺信息
     */
    @GetMapping("/touchShopByShopId")
    @ApiOperation(value = "店铺信息",notes = "点击店铺获取店铺信息")
    public ResultData touchShopByShopId(@RequestParam("shopId") Long shopId,@RequestParam("token") String token){
        List<ShopInfo> shopInfos = repastService.touchShopByShopId(shopId,token);
        if (null != shopInfos){
            return success(shopInfos) ;
        }else {
            return failed();
        }
    }
    /**
     * 店铺内商品列
     * @param shopId
     * @return
     */
    @GetMapping("/getCateByShopId")
    @ApiOperation(value = "商品列信息(一级)",notes = "店铺内的商品列")
    public ResultData getCateByShopId(@RequestParam("shopId") Long shopId,@RequestParam("token") String token){
        List<ProductCat> cateByShopId = repastService.getCateByShopId(shopId,token);
        if (null != cateByShopId){
            return success(cateByShopId);
        }else {
            return failed();
        }
    }
    /**
     * 通过店铺主键查询店铺内提供的服务
     * @param shopId
     * @return
     */
    @GetMapping("/getServerByShopId")
    @ApiOperation(value = "店铺的服务",notes = "通过店铺的主键查询店铺的服务")
    public ResultData getServerByShopId(@RequestParam("shopId") Long shopId,@RequestParam("token") String token){
        List<ShopInfoFacility> serverByShopId = repastService.getServerByShopId(shopId,token);
        if (null != serverByShopId){
            return success(serverByShopId);
        }else {
            return failed();
        }
    }

}
