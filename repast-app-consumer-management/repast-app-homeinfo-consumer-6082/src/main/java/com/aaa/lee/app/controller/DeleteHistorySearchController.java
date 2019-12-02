package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 李永杰
 * @Date 2019/11/23 21:20
 **/
@RestController
@Api(value = "删除搜索历史",tags = "删除用户历史搜索")
public class DeleteHistorySearchController extends BaseController {

    @Autowired
    private IRepastService repastService;
    /**
     * 删除某个用户的历史搜索
     * @param
     * @return
     */
    @GetMapping("/getdeleteHistorySearch")
    @ApiOperation(value = "删除搜索历史",notes = "删除用户历史搜索")
    public ResultData getdeleteHistorySearch(String token){
                Boolean i = repastService.getdeleteHistorySearch(token);
                if (i){
                    return success("删除成功");
                }
                return failed("删除失败");
            }
        }



