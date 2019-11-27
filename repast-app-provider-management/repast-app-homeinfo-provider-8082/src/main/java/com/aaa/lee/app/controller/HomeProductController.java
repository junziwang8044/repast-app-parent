package com.aaa.lee.app.controller;

import com.aaa.lee.app.service.HomeProductAdvertiseService;
import com.aaa.lee.app.service.ProductHotStatusService;
import com.aaa.lee.app.vo.HomeProductAdvertiseVo;
import com.aaa.lee.app.vo.ProductHotBySale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author:RR
 * Description:
 * DATE：2019/11/22
 * PROJECTnNAME:repast-app-parent
 */
@RestController
public class HomeProductController {
    @Autowired
    private HomeProductAdvertiseService homeProductAdvertiseService;
    @Autowired
    private ProductHotStatusService productHotStatusService;

    @GetMapping("/getAdvertiseList")
    public List<HomeProductAdvertiseVo> getAdvertiseList(){
        try {
            List<HomeProductAdvertiseVo> advertiseList = homeProductAdvertiseService.getAdvertiseList();
            return advertiseList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("/getHotProduct")
    public List<ProductHotBySale> getHotProduct(@RequestParam("shopId") Long shopId){
        try {
            List<ProductHotBySale> hotProduct = productHotStatusService.getHotProduct(shopId);
            if(hotProduct.size()>0){
                return hotProduct;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
