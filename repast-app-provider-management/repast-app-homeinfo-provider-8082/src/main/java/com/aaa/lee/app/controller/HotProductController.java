package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.ProductCategory;
import com.aaa.lee.app.service.HotProductService;
import com.aaa.lee.app.service.PacByProductIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @作者：王君君
 * @项目：repast-app-parent
 * @包：com.aaa.lee.app.controller
 * @日期：2019-11-22 11:17
 */
@RestController
public class HotProductController {

    @Autowired
    private HotProductService hotProductService;

    @Autowired
    private PacByProductIdService pacByProductIdService;

    /**
     * 前台进入店铺通过店铺id获取热卖商品信息
     * @return
     */
    @GetMapping("/getHot")
    public List<Product> getHotProduct(@RequestParam("shopId") Long shopId){
        List<Product> hotProduct = hotProductService.getHotProduct(shopId);
        return hotProduct;
    }

    @GetMapping("/getPac")
    public List<ProductCategory> getPacByProductId(@RequestParam("shopId") Long shopId){
        List<ProductCategory> pacByProductId = pacByProductIdService.getPacByProductId(shopId);
        return pacByProductId;
    }

}
