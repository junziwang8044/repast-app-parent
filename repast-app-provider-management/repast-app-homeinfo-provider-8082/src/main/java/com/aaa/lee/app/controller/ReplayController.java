package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Replay;
import com.aaa.lee.app.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    /**
     * 查询回复评论
     * @param commentId
     * @return
     */
    @GetMapping("/selectReplay")
    public List<Replay> selectReplay(@RequestParam("commentId") Long commentId){
        List<Replay> replays = replayService.selectReplay(commentId);
        return replays;
    }
}