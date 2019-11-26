package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 李永杰
 * @Date 2019/11/22 11:20
 **/
@RestController
@Api(value = "搜索",tags = "首页搜索")
public class SearchHomeController extends BaseController {
    @Autowired
    private IRepastService repastService;

    @GetMapping("/getSearchHome")
    @ApiOperation(value = "搜索",notes ="首页搜索商品")
    public ResultData getSearchHome(String name){
        List<Product> searchHome = repastService.getSearchHome(name);
       if(searchHome.size()>0){
         return success("搜索成功",searchHome);
       }
     return failed("搜索失败");
    }
}
