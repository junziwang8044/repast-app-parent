package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.domain.ProductCat;
import com.aaa.lee.app.domain.ShopInfo;
import com.aaa.lee.app.domain.ShopInfoFacility;
import com.aaa.lee.app.service.ProductCatService;
import com.aaa.lee.app.service.ShopInfoFacilityService;
import com.aaa.lee.app.service.ShopInfoService;
import com.aaa.lee.app.vo.ShopInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 11:00
 * @Description
 **/
@RestController
public class ShopInfosController extends BaseController {

    @Autowired
    private ShopInfoService shopInfoService;

    @Autowired
    private ProductCatService productCatService;

    @Autowired
    private ShopInfoFacilityService shopInfoFacilityService;

    /**
     * 通过主键查询店铺信息
     * @param shopId
     * @return
     */
    @GetMapping("/getshopmsgById")
    public ShopInfo getshopmsgById(@RequestParam("shopId") Long shopId) {
        return shopInfoService.getshopmsgById(shopId);
    }

    /**
     * 点击店铺，获取店铺信息
     * @param shopId
     * @return
     */
    @GetMapping("/touchShopByShopId")
    public List<ShopInfo> touchShopByShopId(@RequestParam("shopId") Long shopId){
        List<ShopInfo> shopInfos = shopInfoService.touchShopByShopId(shopId);
        return shopInfos;
    }
    /**
     * 店铺内的商品列
     * @param shopId
     * @return
     */
    @GetMapping("/getCateByShopId")
    public List<ProductCat> getCateByShopId(@RequestParam("shopId") Long shopId){
        List<ProductCat> cateByShopId = productCatService.getCateByShopId(shopId);
        return cateByShopId;
    }
    /**
     * 通过店铺主键查询店铺内提供的服务
     * @param shopId
     * @return
     */
    @GetMapping("/getServerByShopId")
    public List<ShopInfoFacility> getServerByShopId(@RequestParam("shopId") Long shopId){
        try {
            List<ShopInfoFacility> serverByShopId = shopInfoFacilityService.getServerByShopId(shopId);
            if (serverByShopId.size()>0){
                return serverByShopId;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
