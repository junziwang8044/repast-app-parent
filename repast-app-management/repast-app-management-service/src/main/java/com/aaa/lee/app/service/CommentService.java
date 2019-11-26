package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class CommentService extends BaseService<Comment> {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Mapper<Comment> getMapper() {
        return commentMapper;
    }

    /**
     * 根据商品id获取该商品的评论
     * @param id
     * @return
     */
    public List<Comment> selectCommentByProductId(Long id){
        List<Comment> comments = commentMapper.selectCommentByProductId(id);
        return comments;
    }

    /**
     * 根据商品id获取该商品的两条阅读量多的评论
     * @param id
     * @return
     */
    public List<Comment> selectTwoByProductId(Long id){
        List<Comment> twoComment = commentMapper.selectTwoByProductId(id);
        return twoComment;

    }

}
