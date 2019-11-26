package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductPic;
import com.aaa.lee.app.mapper.ProductMapper;
import com.aaa.lee.app.utils.JSONUtil;
import com.aaa.lee.app.vo.ProductParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import static com.aaa.lee.app.staticstatus.StaticProperties.PRODUCT_ID;

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
     * @author Seven Lee
     * @description
     *      通过店铺主键查询商品列表
     * @param [shopId]
     * @date 2019/11/21
     * @return java.util.List<com.aaa.lee.app.domain.Product>
     * @throws 
    **/
    public List<Product> getProductByShopId(Long shopId) {
        List<Product> productList = productMapper.getProductByShopId(shopId);
        if(productList.size() > 0) {
            return productList;
        }
        return null;
    }
    /**
     * 根据商品id查询类似商品
     * @param id
     * @return
     */
    public List<Product> getLikePro(Long id){
        List<Product> likePro = productMapper.getLikePro(id);
        return likePro;
    }

    /**
     * 根据店铺id查询该店商品的推荐
     * @param shopId
     * @return
     */
    public List<Product> getRecommandByShopId(Long shopId){
        List<Product> recommandByShopId = productMapper.getRecommandByShopId(shopId);
        return recommandByShopId;
    }

    /**
     * 根据商品id查询图片
     * @param id
     * @return
     */
    public List<ProductPic> selectPicByShopId(Long id){
        List<ProductPic> productPics = productMapper.selectPicByShopId(id);
        return productPics;
    }

    /**
     * 根据商品id查询上品参数
     * @param id
     * @return
     */
    public List<ProductParam> selectProductParam(Long id){
        List<ProductParam> productParams = productMapper.selectProductParam(id);
        return productParams;
    }

    /**
     * 根据商品id查询商品的图片列表
     * @param id
     * @return
     */
    public List<ProductPic> selectAlbumByProductId(Long id){
        List<ProductPic> productPics = productMapper.selectAlbumByProductId(id);
        return productPics;
    }
    public Product getProductById(Long id ,RedisService redisService){
        String productString = redisService.get(PRODUCT_ID+id);
        if (null == productString || "".equals(productString)) {
            Product product = productMapper.selectByPrimaryKey(id);
            String jsonString = JSONUtil.toJsonString(product);
            redisService.set(PRODUCT_ID+id, jsonString);
            return product;
        }
        Product product1 = JSONUtil.toObject(productString, Product.class);
        return product1;
    }
}
