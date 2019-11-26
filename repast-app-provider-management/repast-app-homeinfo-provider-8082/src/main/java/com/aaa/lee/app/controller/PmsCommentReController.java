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
     *
     * @param id
     * @return
     */

    @GetMapping("/searchAll")
    public  List<PmsCommentRe> searchAll(@RequestParam("id") Long id){

        return  pmsCommentReService.searchAll(id);

    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/showAll")
    public  List<PmsCommentRe> showAll(@RequestParam("id") Long id){

        return  pmsCommentReService.showAll(id);
    }






}
