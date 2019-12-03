package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.Replay;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value ="评论" ,tags = "商品评论接口")
public class CommentController extends BaseController {

    @Autowired
    private IRepastService iRepastService;

    /**
     * 根据商品
     * @param id
     * @return
     */
    @GetMapping("/getCommentByProductId")
    @ApiOperation(value = "商品评论", notes = "查询商品评论")
    public ResultData getCommentByProductId(Long id ,String token){
        List<Comment> commentByProductId = iRepastService.getCommentByProductId(id, token);
        if(commentByProductId.size()>0){
            return operationSuccess(commentByProductId);
        }
        return operationFailed();
    }

    /**
     * 查询商品评论
     * @param id
     * @return
     */
    @GetMapping("/selectTwoByProductId")
    @ApiOperation(value = "商品评论", notes = "查询商品评论")
    public ResultData selectTwoByProductId(Long id ,String token){
        List<Comment> commentByProductId = iRepastService.selectTwoByProductId(id, token);
        if(commentByProductId.size()>0){
            return operationSuccess(commentByProductId);
        }
        return operationFailed();
    }

    /**
     * 添加评论回复
     *
     * @param replay
     * @return
     */
    @PostMapping("/insertReplay")
    @ApiOperation(value="商品评论回复",notes="添加评论回复")
    public ResultData insertReplay(Replay replay ,String token){
        Integer integer = iRepastService.insertReplay(replay,token);
        if(integer>0){
            return operationSuccess();
        }
        return operationFailed();
    }

    /**
     * 查询回复评论
     * @param commentId
     * @return
     */
    @GetMapping("/selectReplay")
    @ApiOperation(value="商品回复",notes="查询评论回复")
    public ResultData selectReplay(Long commentId ,String token){
        List<Replay> replays = iRepastService.selectReplay(commentId ,token);
        if(replays.size()>0){
            return operationSuccess(replays);
        }
        return operationFailed();
    }

}
