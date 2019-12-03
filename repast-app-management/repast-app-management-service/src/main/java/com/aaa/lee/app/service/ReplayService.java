package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.Replay;
import com.aaa.lee.app.mapper.ReplayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReplayService extends BaseService<Replay> {

    @Autowired
    private ReplayMapper replayMapper;

    @Override
    public Mapper<Replay> getMapper() {
        return replayMapper;
    }

    /**
            * 添加评论回复
     * @param replay
     * @return
             */
        public Integer insertReplay(Replay replay ,String token){
            boolean boo = selectToken(token);
            if(boo){
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = formatter.format(date);
                replay.setCreateTime(dateString);
                Integer integer = replayMapper.insertReplay(replay);
                return integer;
                }

            return null;

    }

    /**
     * 查询回复评论
     * @param commentId
     * @return
     */
    public List<Replay> selectReplay(Long commentId ,String token){
        boolean boo = selectToken(token);
        if(boo){
            List<Replay> replays = replayMapper.selectReplay(commentId);
            if(replays.size()>0){
                return replays;
            }
        }
        return null;
    }
}
