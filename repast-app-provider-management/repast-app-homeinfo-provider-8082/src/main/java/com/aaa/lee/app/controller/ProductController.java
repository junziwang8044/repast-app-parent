package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductPic;
import com.aaa.lee.app.service.CommentService;
import com.aaa.lee.app.service.ProductService;
import com.aaa.lee.app.service.RedisService;
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

    @GetMapping("/getCommentByProductId")
    public List<Comment> getCommentByProductId(@RequestParam("id") Long id){
        List<Comment> comments = commentService.selectCommentByProductId(id);
        if(comments.size()>0){
            return comments;
        }
        return null;
    }
    @GetMapping("/selectTwoByProductId")
    public List<Comment> selectTwoByProductId(@RequestParam("id") Long id){
        List<Comment> twoComment = commentService.selectTwoByProductId(id);
        return twoComment;
    }

    /**
     * 根据商品id获取商品
     * @param id
     * @return
     */
    @GetMapping("/getProductById")
    public Product getProductById(@RequestParam("id") Long id){
        Product productById = productService.getProductById(id, redisService);
        return productById;
    }
    @GetMapping("/getLikePro")
    public List<Product> getLikePro(@RequestParam("id") Long id){
        List<Product> likePro = productService.getLikePro(id);
        if(likePro.size()>0){
            return likePro;
        }
        return null;
    }
    /**
     * 根据店铺id查询该店商品的推荐
     * @param shopId
     * @return
     */
    @GetMapping("/getRecommandByShopId")
    public List<Product> getRecommandByShopId(@RequestParam("shopId") Long shopId) {
        List<Product> recommandByShopId = productService.getRecommandByShopId(shopId);
        if (recommandByShopId.size()>0) {
            return recommandByShopId;
        }
        return null;
        }

    /**
     * 根据商品id查询图片
     * @param id
     * @return
     */
    @GetMapping("/selectPicByShopId")
    public List<ProductPic> selectPicByShopId(@RequestParam("id") Long id){
        List<ProductPic> productPics = productService.selectPicByShopId(id);
        if (productPics.size()>0) {
            return productPics;
        }
        return null;
    }
    /**
     * 根据商品id查询商品参数
     * @param id
     * @return
     */
    @GetMapping("/selectProductParam")
    public List<ProductParam> selectProductParam(@RequestParam("id") Long id){
        List<ProductParam> productParams = productService.selectProductParam(id);
        if (productParams.size()>0) {
            return productParams;
        }
        return null;
    }

    /**
     * 根据商品id查询商品的图片列表
     * @param id
     * @return
     */
    @GetMapping("/selectAlbumByProductId")
    public List<ProductPic> selectAlbumByProductId(@RequestParam("id") Long id){
        List<ProductPic> productPics = productService.selectAlbumByProductId(id);
        if (productPics.size()>0) {
            return productPics;
        }
        return null;
    }
    /**
     * 根据商品类目id查询该商店该类目的所有商品
     * @param id
     * @return
     */
    @GetMapping("/selectProducrByType")
    public List<Product> selectProducrByType(@RequestParam("id") Long id){
        List<Product> products = productService.selectProducrByType(id);
        return  products;

    }
}
