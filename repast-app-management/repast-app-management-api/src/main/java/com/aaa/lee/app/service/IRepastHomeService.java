package com.aaa.lee.app.service;

import com.aaa.lee.app.domain.ProductCat;
import com.aaa.lee.app.domain.ShopInfo;
import com.aaa.lee.app.fallback.RepastHomeFallBackFactory;
import com.aaa.lee.app.vo.HomeProductAdvertiseVo;
import com.aaa.lee.app.vo.ProductHotBySale;
import com.aaa.lee.app.vo.ShopInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Author:RR
 * Description:
 * DATE：2019/11/22
 * PROJECTnNAME:repast-app-parent
 */
@FeignClient(value = "homeinfo-interface-provider", fallbackFactory = RepastHomeFallBackFactory.class)
public interface IRepastHomeService {
        /**
         * 获得广告
         * @return
         */
        @GetMapping("/getAdvertiseList")
        List<HomeProductAdvertiseVo> getAdvertiseList();
        /**
         * 获取人气商品
         */
        @GetMapping("/getHotProduct")
        List<ProductHotBySale> getHotProduct(@RequestParam("shopId") Long shopId);
        /**
         * @author Seven Lee
         * @description
         *      通过主键查询店铺信息
         * @param [shopId]
         * @date 2019/11/21
         * @return java.lang.String
         * @throws
         **/
        @GetMapping("/getshopmsgById")
        ShopInfoVo getshopmsgById(@RequestParam("shopId") Long shopId);

        /**
         * 点击店铺获取店铺信息
         */
        @GetMapping("/touchShopByShopId")
        List<ShopInfo> touchShopByShopId(@RequestParam("shopId") Long shopId);

        /**
         * 店铺内的商品列
         */
        @GetMapping("/getCateByShopId")
        List<ProductCat> getCateByShopId(@RequestParam("shopId") Long shopId);

}
