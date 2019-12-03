package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.domain.SmsAdver;
import com.aaa.lee.app.service.SmsAdverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SmsAdverController  extends BaseController {


    @Autowired
    private SmsAdverService smsAdverService;





    @GetMapping("/shopIdList")
    public List<SmsAdver> shopIdList(@RequestParam("shopId") Long shopId,@RequestParam("token") String token){

        return  smsAdverService.shopIdList(shopId,token);

    }





}
