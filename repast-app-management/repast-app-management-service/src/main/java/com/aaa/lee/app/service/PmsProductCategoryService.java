package com.aaa.lee.app.service;


import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.PmsProductCategory;
import com.aaa.lee.app.mapper.PmsProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class PmsProductCategoryService extends BaseService<PmsProductCategory> {

    @Autowired
    private PmsProductCategoryMapper pmsProductCategoryMapper;



    @Override
    public Mapper<PmsProductCategory> getMapper() {

        return pmsProductCategoryMapper;
    }
}
