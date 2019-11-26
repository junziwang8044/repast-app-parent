package com.aaa.lee.app.fallback;

import com.aaa.lee.app.domain.*;
import com.aaa.lee.app.service.IRepastService;
import com.aaa.lee.app.vo.ShopInfoVo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:41
 * @Description
 **/
@Component
public class RepastFallBackFactory implements FallbackFactory<IRepastService> {

    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService() {
            @Override
            public Boolean doLogin(Member member) {
                System.out.println("测试登录熔断数据");
                return null;
            }

            @Override
            public List<MemberReceiveAddress> getMemberReceiveAddress() {
                System.out.println("测试收获地址列表熔断数据");
                return null;
            }

            @Override
            public ShopInfoVo getShopById(Long shopId) {
                System.out.println("测试店铺信息熔断数据");
                return null;
            }

            @Override
            public List<ProductCat> getCategoryByShopId(Long shopId) {
                System.out.println("测试商品类目熔断数据");
                return null;
            }
            @Override
            public List<Product> getProductByShopId(Long shopId) {
                return null;
            }
            @Override
            public List<Product> getHotProduct(Long shopId) {
                System.out.println("测试热卖商品熔断数据");
                return null;
            }

            @Override
            public List<ProductCategory> getPacByProductId(Long shopId) {
                System.out.println("测试上平类目属性列表");
                return null;
            }

            @Override
            public List<Product> getSearchHome(String name) {
                System.out.println("测试搜索首页商品");
                return null;
            }

            @Override
            public Boolean getdeleteHistorySearch() {
                System.out.println("删除某个用户的历史搜索");
                return false;
            }

        };
        return repastService;
    }
}
