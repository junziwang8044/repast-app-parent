package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductPic;
import com.aaa.lee.app.service.CommentService;
import com.aaa.lee.app.service.ProductService;
import com.aaa.lee.app.service.RedisService;
import com.aaa.lee.app.vo.CanTeenDateVo;
import com.aaa.lee.app.vo.ProductParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private RedisService redisService;

    /**
     * 根据商品id查询评论
     * @param id
     * @return
     */
    @GetMapping("/getCommentByProductId")
    public List<Comment> getCommentByProductId(@RequestParam("id") Long id,@RequestParam("token") String token) {
        List<Comment> comments = commentService.selectCommentByProductId(id,token);
        if (comments.size() > 0) {
            return comments;
        }
        return null;
    }

    /**
     * 根据商品id查询评论(两条)
     * @param id
     * @return
     */
    @GetMapping("/selectTwoByProductId")
    public List<Comment> selectTwoByProductId(@RequestParam("id") Long id,@RequestParam("token") String token) {
        List<Comment> twoComment = commentService.selectTwoByProductId(id,token);
        return twoComment;
    }

    /**
     * 根据商品id获取商品
     *
     * @param id
     * @return
     */
    @GetMapping("/getProductById")
    public Product getProductById(@RequestParam("id") Long id ,@RequestParam("token") String token) {
        Product productById = productService.getProductById(id, redisService,token);
        return productById;
    }

    /**
     * 根据商品id查询雷士商品
     * @param id
     * @return
     */
    @GetMapping("/getLikePro")
    public List<Product> getLikePro(@RequestParam("id") Long id,@RequestParam("token") String token) {
        List<Product> likePro = productService.getLikePro(id,token);
        if (likePro.size() > 0) {
            return likePro;
        }
        return null;
    }

    /**
     * 根据店铺id查询该店商品的推荐
     *
     * @param shopId
     * @return
     */
    @GetMapping("/getRecommandByShopId")
    public List<Product> getRecommandByShopId(@RequestParam("shopId") Long shopId,@RequestParam("token") String token) {
        List<Product> recommandByShopId = productService.getRecommandByShopId(shopId,token);
        if (recommandByShopId.size() > 0) {
            return recommandByShopId;
        }
        return null;
    }

    /**
     * 根据商品id查询图片
     *
     * @param id
     * @return
     */
    @GetMapping("/selectPicByShopId")
    public List<ProductPic> selectPicByShopId(@RequestParam("id") Long id,@RequestParam("token") String token) {
        List<ProductPic> productPics = productService.selectPicByShopId(id,token);
        if (productPics.size() > 0) {
            return productPics;
        }
        return null;
    }

    /**
     * 根据商品id查询商品参数
     *
     * @param id
     * @return
     */
    @GetMapping("/selectProductParam")
    public List<ProductParam> selectProductParam(@RequestParam("id") Long id ,@RequestParam("token") String token) {
        List<ProductParam> productParams = productService.selectProductParam(id, token);
        if (productParams.size() > 0) {
            return productParams;
        }
        return null;
    }

    /**
     * 根据商品id查询商品的图片列表
     *
     * @param id
     * @return
     */
    @GetMapping("/selectAlbumByProductId")
    public List<ProductPic> selectAlbumByProductId(@RequestParam("id") Long id,@RequestParam("token") String token) {
        List<ProductPic> productPics = productService.selectAlbumByProductId(id, token);
        if (productPics.size() > 0) {
            return productPics;
        }
        return null;
    }

    @GetMapping("/getCanteenDateByShopId")
    List<CanTeenDateVo> getCanteenDateByShopId(@RequestParam("shopId") Long ShopId,@RequestParam("token") String token) {
        return productService.getCanteenDateByShopId(ShopId,token);//想好，如果使用一对多嵌套的实体类Vo，这样就没办法进redis查询了


    }

    /**
     * 根据商品类目id查询该商店该类目的所有商品
     * @param id
     * @return
     */

    @GetMapping("/selectProducrByType")
    public List<Product> selectProducrByType(@RequestParam("id") Long id,@RequestParam("token") String token){
        List<Product> products = productService.selectProducrByType(id,token);
        return products;
    }
}