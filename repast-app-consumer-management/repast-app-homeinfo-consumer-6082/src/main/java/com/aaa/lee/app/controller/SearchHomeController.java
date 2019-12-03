package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.PmsCommentRe;
import com.aaa.lee.app.domain.PmsProduct;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.domain.SmsAdver;
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

    /**
     * 首页搜索
     * @param name
     * @return
     */
    @GetMapping("/getSearchHome")
    @ApiOperation(value = "搜索",notes ="首页搜索商品")
    public ResultData getSearchHome(String name,String token){
        List<Product> searchHome = repastService.getSearchHome(name,token);
       if(searchHome.size()>0){
         return success("搜索成功",searchHome);
       }
     return failed("搜索失败");
    }


    /**
     * 根据id查到商品上架下架状态
     * @param brandId
     * @return
     */
    @GetMapping("/selectAll")
    @ApiOperation(value = "查询商品状态信息", notes = "执行查询商品类型操作，查询上架和未删除状态的商品")
    public ResultData getSelectAll(Long brandId,String token) {
        List<PmsProduct> getSelectAll = repastService.getSelectAll(brandId,token);
        if (getSelectAll.size() > 0) {
            return success(getSelectAll);
        } else {
            return failed();
        }
    }

    /**
     * 更多搜索展示搜索过历史全部
     * @param id
     * @return
     */
    @GetMapping("/searchAll")
    @ApiOperation(value = "查询搜索历史(更多搜索历史)", notes = "查询搜索过的信息历史")
    public ResultData searchAll(Long id,String token){
        List<PmsCommentRe> pmsCommentRes = repastService.searchAll(id,token);
        if (pmsCommentRes.size() > 0) {
            return success(pmsCommentRes);
        } else {
            return failed();
        }
    }


    /**
     * 在搜索框下展示以往搜索过的内容，展示一两条
     * @param id
     * @return
     */
    @GetMapping("/showAll")
    @ApiOperation(value = "搜索框下展示的历史搜索", notes = "搜索框下展示的历史搜索，默认显示几条")
    public  ResultData showAll(Long id,String token){
        List<PmsCommentRe> all = repastService.showAll(id,token);
        if (all.size() > 0){
            return success(all);
        }else {
            return  failed();
        }

    }
    @GetMapping("/shopIdList")
    @ApiOperation(value = "查询店铺广告图片", notes = "根据id店铺为1的全部查询出来")
    public  ResultData shopIdList(Long shopId,String token){
        List<SmsAdver> smsAdvers = repastService.shopIdList(shopId,token);
        if (smsAdvers.size() > 0){
            return  success(smsAdvers);
        }else {

            return failed();
        }


    }


}
