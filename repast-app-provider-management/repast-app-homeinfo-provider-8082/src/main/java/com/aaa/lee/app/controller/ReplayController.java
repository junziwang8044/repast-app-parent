package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Replay;
import com.aaa.lee.app.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplayController {

    @Autowired
    private ReplayService replayService;

    /**
     * 添加评论回复
     * @param replay
     * @return
     */
    @PostMapping("/insertReplay")
    public Integer insertReplay(@RequestBody Replay replay) {
        Integer integer = replayService.insertReplay(replay);
        return integer;
    }
}