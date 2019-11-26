package com.aaa.lee.app.mapper;

import com.aaa.lee.app.domain.Comment;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommentMapper extends Mapper<Comment> {

    List<Comment> selectCommentByProductId(Long id);
    List<Comment> selectTwoByProductId(Long id);


}