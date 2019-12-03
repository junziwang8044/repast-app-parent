package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductPic;
import com.aaa.lee.app.domain.Replay;
import com.aaa.lee.app.mapper.ProductMapper;
import com.aaa.lee.app.utils.JSONUtil;
import com.aaa.lee.app.vo.CanTeenDateVo;
import com.aaa.lee.app.vo.ProductParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import static com.aaa.lee.app.staticstatus.StaticProperties.*;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/21 11:57
 * @Description
 **/
@Service
public class ProductService extends BaseService<Product> {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Mapper<Product> getMapper() {
        return productMapper;
    }

    /**
     * @param [shopId]
     * @return java.util.List<com.aaa.lee.app.domain.Product>
     * @throws
     * @author Seven Lee
     * @description 通过店铺主键查询商品列表
     * @date 2019/11/21
     **/
    public List<Product> getProductByShopId(Long shopId ,String token) {
        boolean boo = selectToken(token);
        if(boo){
            List<Product> productList = productMapper.getProductByShopId(shopId);
            if(productList.size()>0){
                return productList;
            }
        }
        return null;
    }

    /**
     * 根据商品id查询类似商品
     *
     * @param id
     * @return
     */
    public List<Product> getLikePro(Long id ,String token) {
        boolean boo = selectToken(token);
        if(boo){
            List<Product> likePro = productMapper.getLikePro(id);
            if(likePro.size()>0){
                return likePro;
            }
        }
        return null;
    }

    /**
     * 根据店铺id查询该店商品的推荐
     *
     * @param shopId
     * @return
     */
    public List<Product> getRecommandByShopId(Long shopId ,String token) {
        boolean boo = selectToken(token);
        if(boo){
            List<Product> recommandByShopId = productMapper.getRecommandByShopId(shopId);
            if(recommandByShopId.size()>0){
                return recommandByShopId;
            }
        }
        return null;
    }

    /**
     * 根据商品id查询图片
     *
     * @param id
     * @return
     */
    public List<ProductPic> selectPicByShopId(Long id ,String token) {
        boolean boo = selectToken(token);
        if(boo){
            List<ProductPic> productPics = productMapper.selectPicByShopId(id);
            if(productPics.size()>0){
                return productPics;
            }
        }
        return null;
    }

    /**
     * 根据商品id查询上品参数
     *
     * @param id
     * @return
     */
    public List<ProductParam> selectProductParam(Long id ,String token) {
        boolean boo = selectToken(token);
        if(boo){
            List<ProductParam> productParams = productMapper.selectProductParam(id);
            if(productParams.size()>0){
                return productParams;
            }
        }
        return null;
    }

    /**
     * 根据商品id查询商品的图片列表
     *
     * @param id
     * @return
     */
    public List<ProductPic> selectAlbumByProductId(Long id ,String token) {
        boolean boo = selectToken(token);
        if(boo){
            List<ProductPic> productPics = productMapper.selectAlbumByProductId(id);
            if(productPics.size()>0){
                return productPics;
            }
        }
        return null;
    }

    /**
     * 根据商品id查询商品
     *
     * @param id
     * @return
     */
    public Product getProductById(Long id, RedisService redisService,String token) {
        boolean boo = selectToken(token);
        if(boo){
            String productString = redisService.get(PRODUCT_ID + id);
            if (null == productString || "".equals(productString)) {
                Product product = productMapper.selectByPrimaryKey(id);
                String jsonString = JSONUtil.toJsonString(product);
                redisService.set(PRODUCT_ID + id, jsonString);
                return product;
            }
            Product product1 = JSONUtil.toObject(productString, Product.class);
            return product1;
        }
        return null;
    }
    /**
     * 根据店铺id查询商品
     *
     * @param
     * @return
     */
    public List<CanTeenDateVo> getCanteenDateByShopId(Long ShopId ,String token) {
        boolean boo = selectToken(token);
        if(boo){
            List<CanTeenDateVo> canteenDateByShopId = productMapper.getCanteenDateByShopId(ShopId);
            if(canteenDateByShopId.size()>0){
                return canteenDateByShopId;
            }
        }
        return null;

    }

    /**
     * 根据商品类目id查询该商店该类目的所有商品
     * @param id
     * @return
     */
    public List<Product> selectProducrByType (Long id ,String token){
        boolean boo = selectToken(token);
        if(boo){
            List<Product> products = productMapper.selectProducrByType(id);
            if(products.size()>0){
                return products;
            }
        }
        return null;
    }
}
