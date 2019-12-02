package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.service.ProductSearchHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 李永杰
 * @Date 2019/11/22 11:20
 **/
@RestController
public class SearchHomeController {
    @Autowired
    private ProductSearchHomeService productSearchHomeService;
    /**
     * 首页搜索
     * @param name
     * @return
     */
    @GetMapping("/getSearchHome")
    public List<Product> getSearchHome(String name){

        return  productSearchHomeService.getSearchHome(name);
    }
}
