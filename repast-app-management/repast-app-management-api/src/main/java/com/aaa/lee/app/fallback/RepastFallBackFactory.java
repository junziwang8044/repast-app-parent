package com.aaa.lee.app.fallback;

import com.aaa.lee.app.domain.*;
import com.aaa.lee.app.service.IRepastService;
import com.aaa.lee.app.vo.*;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

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
            public List<Product> getHotProduct(Long shopId ,String token) {
                System.out.println("测试热卖商品熔断数据");
                return null;
            }

            @Override
            public List<Product> getSearchHome(String name, String token) {
                System.out.println("测试搜索首页商品");
                return null;
            }

            @Override
            public Boolean getdeleteHistorySearch(String token) {
                System.out.println("删除某个用户的历史搜索");
                return false;
            }


            @Override
            public List<PmsProduct> getSelectAll(Long brandId,String token) {
                System.out.println("根据id查到商品上架下架和删除未删除的状态（商品的状态）");
                return null;
            }

            @Override
            public List<PmsCommentRe> searchAll(Long id,String token) {
                System.out.println("更多搜索展示搜索过历史全部");
                return null;
            }

            @Override
            public List<PmsCommentRe> showAll(Long id,String token) {
                System.out.println("在搜索框下展示以往搜索过的内容，展示一两条");
                return null;
            }

            @Override
            public Product getProductById(Long id,String token) {
                System.out.println("商品详情展示熔断");
                return null;
            }

            @Override
            public List<Comment> getCommentByProductId(Long id,String token) {
                System.out.println("商品评论展示熔断");
                return null;
            }

            @Override
            public List<Product> getLikePro(Long id,String token) {
                System.out.println("类似商品展示熔断");
                return null;
            }

            @Override
            public List<Comment> selectTwoByProductId(Long id,String token) {
                System.out.println("商品两评论展示熔断");
                return null;
            }

            @Override
            public List<Product> getRecommandByShopId(Long shopId,String token) {
                System.out.println("店铺推荐熔断");
                return null;
            }

            @Override
            public Integer insertReplay(Replay replay,String token) {
                System.out.println("回复评论熔断");
                return null;
            }

            @Override
            public List<ProductPic> selectPicByShopId(Long id,String token) {
                System.out.println("查询商店图片熔断");
                return null;
            }

            @Override
            public List<ProductParam> selectProductParam(Long id,String token) {
                System.out.println("商品参数熔断");
                return null;
            }

            @Override
            public List<ProductPic> selectAlbumByProductId(Long id,String token) {
                System.out.println("商品图片熔断");
                return null;
            }
            @Override
            public List<ProductCatG> getCategoryByShopId1(Long shopId,String token) {
                System.out.println("测试获取商品类目熔断数据");
                return null;
            }

            @Override
            public List<ShopList> getShopList() {
                System.out.println("测试获取所有商店信息进入熔断");
                return null;
            }

            @Override
            public List<HomeProductAdvertiseVo> getAdvertiseList() {
                System.out.println("获取广告图片熔断");
                return null;
            }

            @Override
            public List<ProductHotBySale> getHotProducts(@RequestParam("shopId") Long shopId) {
                System.out.println("获取人气商品熔断");
                return null;
            }

            @Override
            public ShopInfo getShopMsgById(@RequestParam("shopId") Long shopId,@RequestParam("token") String token) {
                System.out.println("商品详情熔断");
                return null;
            }
            @Override
            public List<ShopInfo> touchShopByShopId(@RequestParam("shopId") Long shopId,@RequestParam("token") String token) {
                System.out.println("测试点击店铺信息熔断");
                return null;
            }
            @Override
            public List<ProductCat> getCateByShopId(@RequestParam("shopId") Long shopId,@RequestParam("token") String token) {
                System.out.println("测试店铺内商品列熔断");
                return null;
            }
            @Override
            public List<ShopInfoFacility> getServerByShopId(Long shopId,@RequestParam("token") String token) {
                System.out.println("测试店铺服务熔断");
                return null;
            }

            @Override
            public List<SmsAdver> shopIdList(Long shopId,String token) {
                System.out.println("根据店铺id查询广告位的图片");
                return null;
            }

            @Override
            public List<Product> selectProducrByType(Long id,String token) {
                System.out.println("根据商品类目获取商品熔断");
                return null;
            }

            @Override
            public List<Replay> selectReplay(Long commentId,String token) {
                System.out.println("查询回复熔断");
                return null;
            }

            @Override
            public List<CanTeenDateVo> getCanteenDateByShopId(Long ShopId,String token) {
                System.out.println("进入"+"老杨根据店铺信息获取一级菜单以及商品信息Canteen数据"+"熔断方法");
                return null;
            }
        };
        return repastService;
    }
}
