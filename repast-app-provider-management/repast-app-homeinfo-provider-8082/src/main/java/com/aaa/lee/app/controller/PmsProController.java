package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.PmsProduct;
import com.aaa.lee.app.service.PmsProductCategoryService;
import com.aaa.lee.app.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PmsProController {
    @Autowired
    private PmsProductCategoryService pmsProductCategoryService;

    @Autowired
    private PmsProductService pmsproductService;


    /**
     *  通过id查询商品上架下架和删除为删除的商品状态
     *  下架和删除的商品在数据库可以查看，不在页面展示
     *  id 1, id 2  一个是商品的删除状态 一个是商品的下架状态 所以查不到这两个id的商品状态
     * @param brandId
     * @return
     */
    @GetMapping("/selectAll")
    public List<PmsProduct> getSelectAll(@RequestParam("brandId") Long brandId,@RequestParam("token") String token){

        return pmsproductService.getSelectAll(brandId,token);
    }
}
