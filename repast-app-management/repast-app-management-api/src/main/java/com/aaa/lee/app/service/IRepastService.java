package com.aaa.lee.app.service;

import com.aaa.lee.app.domain.*;
import com.aaa.lee.app.fallback.RepastFallBackFactory;
import com.aaa.lee.app.vo.ProductParam;
import com.aaa.lee.app.vo.ShopInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:40
 * @Description
 *      当使用feign进行传参的时候，如果是对象,包装类型,实体类...必须要使用@RequestBody，并且这个@RequestBody只能在该方法中出现一次
 *          ResultData selectUsersCondition(@RequestBody User user, @RequestBody UserInfo userInfo);---->错误
 *      当传递的参数是简单类型(String, Integer....8种基本类型+String)，必须要使用@RequestParam("")，这个@RequestPara注解可以出现多个
 *          ResultData selectUsersCondition(@RquestPara("username") String username, @RequestParam("age") Integer age);---->正确
 *
 **/
@FeignClient(value = "homeinfo-interface-provider", fallbackFactory = RepastFallBackFactory.class)
public interface IRepastService {

    /**
     * @author Seven Lee
     * @description
     *      执行登录操作
     * @param [member]
     * @date 2019/11/21
     * @return java.lang.Boolean
     * @throws 
    **/
    @PostMapping("/login")
    Boolean doLogin(@RequestBody Member member);

    /**
     * @author Seven Lee
     * @description
     *      根据会员id获取会员收获地址列表
     * @param []
     * @date 2019/11/21
     * @return java.util.List<com.aaa.lee.app.domain.MemberReceiveAddress>
     * @throws 
    **/
    @GetMapping("/receive")
    List<MemberReceiveAddress> getMemberReceiveAddress();

    /**
     * @author Seven Lee
     * @description
     *      通过主键查询店铺信息
     * @param [shopId]
     * @date 2019/11/21
     * @return java.lang.String
     * @throws 
    **/
    @GetMapping("/getById")
    ShopInfoVo getShopById(@RequestParam("shopId") Long shopId);

    /**
     * @author Seven Lee
     * @description
     *      通过店铺主键查询商品类目列表
     * @param [shopId]
     * @date 2019/11/21
     * @return com.aaa.lee.app.base.ResultData
     * @throws 
    **/
    @GetMapping("/getCatByShopId")
    List<ProductCat> getCategoryByShopId(Long shopId);

    /**
     * @author Seven Lee
     * @description
     *      通过店铺主键查询商品列表
     * @param [shopId]
     * @date 2019/11/21
     * @return java.util.List<com.aaa.lee.app.domain.Product>
     * @throws 
    **/
    @GetMapping("/getProductByShopId")
    List<Product> getProductByShopId(Long shopId);

    /**
     * 前台进入店铺通过店铺id获取热卖商品信息
     * @return
     */
    @GetMapping("/getHot")
    List<Product> getHotProduct(@RequestParam("shopId") Long shopId);

    /**
     * 通过商品id获取商品属性列表
     * @return
     */
    @GetMapping("/getPac")
    List<ProductCategory> getPacByProductId(@RequestParam("shopId") Long shopId);

    /**
     * 查询商品
     * @param name
     * @return
     */
    @GetMapping("/getSearchHome")
    List<Product> getSearchHome(@RequestParam("name") String name);

    /**
     * 删除某个用户的历史搜索
     * @param
     * @return
     */
    @GetMapping("/getdeleteHistorySearch")
    Boolean getdeleteHistorySearch();






    /**
     *      通过id查询商品上架下架和删除为删除的商品状态（商品属性、状态）
     **/
    @GetMapping("/selectAll")
    List<PmsProduct> getSelectAll(@RequestParam("brandId") Long brandId);

    /**
     *      通过id查询查询以往搜索过的搜索历史（更多搜索历史）
     **/
    @GetMapping("/searchAll")
    List<PmsCommentRe> searchAll(@RequestParam("id") Long id);



    /**
     *      通过id查询以往搜索过的搜索历史在搜索框下展示的以往的搜索历史展示一两条（搜索的一两条展示）
     **/
    @GetMapping("/showAll")
    List<PmsCommentRe> showAll(@RequestParam("id") Long id);

    /**
     * 通过商品id查询商品详情
     * @param id
     * @return
     */
    @GetMapping("/getProductById")
    Product getProductById(@RequestParam("id") Long id);

    /**
     * 根据商品id获取商品的评论
     * @param id
     * @return
     */
    @GetMapping("/getCommentByProductId")
    List<Comment> getCommentByProductId(@RequestParam("id") Long id);

    /**
     * 根据商品id获取商品的类似推荐商品
     * @param id
     * @return
     */
    @GetMapping("/getLikePro")
    List<Product> getLikePro(@RequestParam("id") Long id);

    /**
     * 根据商品id获取商品阅读量高的前两个评论
     * @param id
     * @return
     */
    @GetMapping("/selectTwoByProductId")
    List<Comment> selectTwoByProductId(@RequestParam("id") Long id);

    /**
     * 根据店铺id查询该店商品的推荐
     * @param shopId
     * @return
     */
    @GetMapping("/getRecommandByShopId")
    List<Product> getRecommandByShopId(@RequestParam("shopId") Long shopId);

    /**
     * 添加评论回复
     *
     * @param replay
     * @return
     */
    @PostMapping("/insertReplay")
    Integer insertReplay(@RequestBody Replay replay);

    /**
     * 根据商品id查询图片列表
     * @param id
     * @return
     */
    @GetMapping("/selectPicByShopId")
    List<ProductPic> selectPicByShopId(@RequestParam("id") Long id);

    /**
     * 根据商品id查询商品参数
     * @param id
     * @return
     */
    @GetMapping("/selectProductParam")
    List<ProductParam> selectProductParam(@RequestParam("id") Long id);

    /**
     * 根据商品id查询商品的图片列表
     * @param id
     * @return
     */
    @GetMapping("/selectAlbumByProductId")
    List<ProductPic> selectAlbumByProductId(@RequestParam("id") Long id);




}
