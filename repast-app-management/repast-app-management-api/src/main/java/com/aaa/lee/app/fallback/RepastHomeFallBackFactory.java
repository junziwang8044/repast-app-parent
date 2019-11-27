package com.aaa.lee.app.fallback;

import com.aaa.lee.app.domain.ProductCat;
import com.aaa.lee.app.domain.ShopInfo;
import com.aaa.lee.app.service.IRepastHomeService;
import com.aaa.lee.app.vo.HomeProductAdvertiseVo;
import com.aaa.lee.app.vo.ProductHotBySale;
import com.aaa.lee.app.vo.ShopInfoVo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author:RR
 * Description:
 * DATE：2019/11/22
 * PROJECTnNAME:repast-app-parent
 */
@Component
public class RepastHomeFallBackFactory implements FallbackFactory<IRepastHomeService> {
    @Override
    public IRepastHomeService create(Throwable throwable) {
        IRepastHomeService homeService = new IRepastHomeService(){

            @Override
            public List<HomeProductAdvertiseVo> getAdvertiseList() {
                System.out.println("获取广告图片熔断");
                return null;
            }

            @Override
            public List<ProductHotBySale> getHotProduct(@RequestParam("shopId") Long shopId) {
                System.out.println("获取人气商品熔断");
                return null;
            }

            @Override
            public ShopInfoVo getshopmsgById(@RequestParam("shopId") Long shopId) {
                System.out.println("商品详情熔断");
                return null;
            }
            @Override
            public List<ShopInfo> touchShopByShopId(Long shopId) {
                System.out.println("测试点击店铺信息熔断");
                return null;
            }
            @Override
            public List<ProductCat> getCateByShopId(Long shopId) {
                System.out.println("测试店铺内商品列熔断");
                return null;
            }
        };
        return null;
    }
}
