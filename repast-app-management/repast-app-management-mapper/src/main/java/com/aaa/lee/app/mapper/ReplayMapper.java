package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Replay;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ReplayMapper extends Mapper<Replay> {

    Integer insertReplay(Replay replay);

    List<Replay> selectReplay(Long commentId);
}