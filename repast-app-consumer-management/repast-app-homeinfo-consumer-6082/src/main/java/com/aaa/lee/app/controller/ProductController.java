package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductPic;
import com.aaa.lee.app.service.IRepastService;
import com.aaa.lee.app.vo.CanTeenDateVo;
import com.aaa.lee.app.vo.ProductParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "商品信息", tags = "商品信息接口")
public class ProductController extends BaseController {
    @Autowired
    private IRepastService iRepastService;

    /**
     * 根据商品id查询商品详情
     * @param id
     * @return
     */
    @GetMapping("/getProductById")
    @ApiOperation(value="商品详情",notes = "根据id查询商品详情")
    public ResultData getProductById(Long id,String token){
        Product productById = iRepastService.getProductById(id,token);
        if(null != productById){
            return operationSuccess(productById);
        }
        return operationFailed();
    }
    /**
     * 根据商品id获取商品的类似推荐商品
     * @param id
     * @return
     */
    @GetMapping("/getLikePro")
    @ApiOperation(value="类似商品",notes = "根据商品id查询类似商品")
    public ResultData getLikePro(Long id,String token){
        List<Product> likePro = iRepastService.getLikePro(id,token);
        if(likePro.size()>0){
            return operationSuccess(likePro);
        }
        return operationFailed();
    }

    /**
     * 根据店铺id查询该店商品的推荐
     * @param shopId
     * @return
     */
    @GetMapping("/getRecommandByShopId")
    @ApiOperation(value="店长推荐",notes="根据店铺id查询该店商品的推荐")
    public ResultData getRecommandByShopId(Long shopId,String token){
        List<Product> recommandByShopId = iRepastService.getRecommandByShopId(shopId,token);
        if(recommandByShopId.size()>0){
            return operationSuccess(recommandByShopId);
        }
        return operationFailed();
    }

    /**
     * 根据商品id查询图片列表
     * @param id
     * @return
     */
    @GetMapping("/selectPicByShopId")
    @ApiOperation(value="商店图片",notes="根据商品id查询图店列表")
    public ResultData selectPicByShopId(Long id,String token){
        List<ProductPic> productPics = iRepastService.selectPicByShopId(id,token);
        if(productPics.size()>0){
            return operationSuccess(productPics);
        }
        return operationFailed();
    }

    /**
     * 根据商品id查询商品参数
     * @param id
     * @return
     */
    @GetMapping("/selectProductParam")
    @ApiOperation(value="商品参数",notes = "根据商品id查询商品参数")
    public ResultData selectProductParam(Long id,String token){
        List<ProductParam> productParams = iRepastService.selectProductParam(id,token);
        if(productParams.size()>0){
            return operationSuccess(productParams);
        }
        return operationFailed();
    }

    /**
     * 根据商品id查询商品的图片列表
     * @param id
     * @return
     */
    @GetMapping("/selectAlbumByProductId")
    @ApiOperation(value="商品图集",notes = "根据商品id查询商品图片")
    public ResultData selectAlbumByProductId(Long id,String token){
        List<ProductPic> productPics = iRepastService.selectAlbumByProductId(id, token);
        if(productPics.size()>0){
            return operationSuccess(productPics);
        }
        return operationFailed();
    }


    @GetMapping("/getCanteenDateByShopId")
    @ApiOperation(value = "根据店铺id查询该店铺的一级菜单以及商品信息",notes = "之前写的查询商品信息不能用了，因为跟前端的格式对不上")
    public ResultData getCanteenDateByShopId(@RequestParam("shopId") Long ShopId,String token){
        List<CanTeenDateVo> canteenDateByShopId = iRepastService.getCanteenDateByShopId(ShopId,token);


        if (null!=canteenDateByShopId){

            return success(canteenDateByShopId);
        }
        return failed();
    }

    /**
     * 根据商品类目id查询该商店该类目的所有商品
     * @param id
     * @return
     */
    @GetMapping("/selectProducrByType")
    public ResultData selectProducrByType(Long id,String token){
        List<Product> products = iRepastService.selectProducrByType(id,token);
        if(products.size()>0){
            return operationSuccess(products);
        }
        return operationFailed();
    }

}
