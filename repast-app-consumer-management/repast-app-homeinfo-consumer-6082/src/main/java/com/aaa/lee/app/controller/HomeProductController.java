package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.service.IRepastService;
import com.aaa.lee.app.vo.HomeProductAdvertiseVo;
import com.aaa.lee.app.vo.ProductHotBySale;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author:RR
 * Description:
 * DATE：2019/11/22
 * PROJECTnNAME:repast-app-project
 */
@RestController
@Api(value = "商品",tags = "查询商品")
public class HomeProductController extends BaseController {
    @Autowired
    private IRepastService repastService;
    /**
     * 查询广告位图片信息
     * @param member
     * @return
     */
    @GetMapping("/getAdvertiseList")
    @ApiOperation(value = "广告信息", notes = "查询广告信图片息")
    public ResultData getAdvertiseList(){
        List<HomeProductAdvertiseVo> advertiseList = repastService.getAdvertiseList();
        //System.out.println(advertiseList);
        if (null!=advertiseList){
            //System.out.println(advertiseList);
            return success(advertiseList);
        }
        return failed();
    }
//    /**
//     * 查询人气商品
//     * @param member
//     * @return
//     */
//    @GetMapping("/getHotProduct")
//    @ApiOperation(value = "查询",notes = "查询人气商品")
//    public ResultData getHotProducts(@RequestParam("shopId") Long shopId){
//        List<ProductHotBySale> hotProduct = repastService.getHotProduct(shopId);
//        if(null!=hotProduct){
//            return success(hotProduct);
//        }
//        return failed();
//    }

}
