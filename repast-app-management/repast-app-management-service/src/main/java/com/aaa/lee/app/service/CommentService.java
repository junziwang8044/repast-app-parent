package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.mapper.CommentMapper;
import com.aaa.lee.app.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class CommentService extends BaseService<Comment> {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Mapper<Comment> getMapper() {
        return commentMapper;
    }

    /**
     * 根据商品id获取该商品的评论
     * @param id
     * @return
     */
    public List<Comment> selectCommentByProductId(Long id ,String token){
        boolean boo = selectToken(token);
        if(boo){
            List<Comment> comments = commentMapper.selectCommentByProductId(id);
            if(comments.size()>0){
                return comments;
            }
        }

        return null;

    }

    /**
     * 根据商品id获取该商品的两条阅读量多的评论
     * @param id
     * @return
     */
    public List<Comment> selectTwoByProductId(Long id ,String token){
        boolean boo = selectToken(token);
        if(boo){
            List<Comment> twoComment = commentMapper.selectTwoByProductId(id);
            if(twoComment.size()>0){
                return twoComment;
            }
        }
        return null;
    }

}
