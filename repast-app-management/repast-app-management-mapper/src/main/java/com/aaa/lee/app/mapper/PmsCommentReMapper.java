package com.aaa.lee.app.mapper;


import com.aaa.lee.app.domain.PmsCommentRe;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PmsCommentReMapper extends Mapper<PmsCommentRe> {


    /**
     *      通过id查询查询以往搜索过的搜索历史（更多搜索历史）
     **/
    List<PmsCommentRe> searchAll(Long id);

    /**
     *      通过id查询以往搜索过的搜索历史在搜索框下展示的以往的搜索历史展示一两条（搜索的一两条展示）
     **/

    List<PmsCommentRe> showAll(Long id);




}