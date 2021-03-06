package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.PmsCommentRe;
import com.aaa.lee.app.service.PmsCommentReService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PmsCommentReController {

    @Autowired
    private PmsCommentReService pmsCommentReService;

    /**
     *  更多搜索展示搜索过历史全部
     * @param id
     * @return
     */

    @GetMapping("/searchAll")
    public  List<PmsCommentRe> searchAll(@RequestParam("id") Long id,@RequestParam("token") String token){

        return  pmsCommentReService.searchAll(id,token);

    }

    /**
     *  在搜索框下展示以往搜索过的内容，展示一两条
     * @param id
     * @return
     */
    @GetMapping("/showAll")
    public  List<PmsCommentRe> showAll(@RequestParam("id") Long id,@RequestParam("token") String token){

        return  pmsCommentReService.showAll(id,token);
    }






}
