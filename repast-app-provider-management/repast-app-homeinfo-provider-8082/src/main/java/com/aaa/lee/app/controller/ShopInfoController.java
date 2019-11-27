package com.aaa.lee.app.controller;


import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.domain.ProductCatG;
import com.aaa.lee.app.domain.ShopList;
import com.aaa.lee.app.service.ProductCatGService;
import com.aaa.lee.app.service.ShopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopInfoController extends BaseController {
    @Autowired
    private ProductCatGService productCatGService;
    @Autowired
    private ShopListService shopListService;
    /**
     * 通过商店的id获得商品的类目
     * @param shopid
     * @return
     */
    @GetMapping("/getCatByShopId")
    public List<ProductCatG> getCategoryByShopId1(@RequestParam("shopId") Long shopid){
        ProductCatG productCat = new ProductCatG().setShopId(shopid);
        try {
            List<ProductCatG> catList = productCatGService.selectDomain(productCat);
            if(catList.size()>0){
                return catList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取所有商品信息
     * @return
     */
    @GetMapping("/getShopList")
    public List<ShopList> getShopList(){
        List<ShopList> shopList = shopListService.getShopList();
        if (null!=shopList){
            return shopList;
        }
        return null;
    }
}
