package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.PmsCommentRe;
import com.aaa.lee.app.mapper.PmsCommentReMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class PmsCommentReService extends BaseService<PmsCommentRe> {

    @Autowired
    private PmsCommentReMapper pmsCommentReMapper;

    @Override
    public Mapper<PmsCommentRe> getMapper() {
        return pmsCommentReMapper;
    }




    public List<PmsCommentRe> searchAll(Long id) {
        List<PmsCommentRe> list = pmsCommentReMapper.searchAll(id);
        if(list.size() > 0) {
            return list;
        }
        return null;

    }

   public  List<PmsCommentRe> showAll(Long id){
       List<PmsCommentRe> showAll = pmsCommentReMapper.showAll(id);
       if (showAll.size() >0){
           return showAll;
       }else {
           return null;
       }
   }


}
