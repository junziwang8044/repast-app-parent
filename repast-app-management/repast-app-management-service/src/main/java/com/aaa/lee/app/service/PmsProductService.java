package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.PmsProduct;
import com.aaa.lee.app.mapper.PmsProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class PmsProductService extends BaseService<PmsProduct> {
    @Autowired
    private PmsProductMapper pmsProductMapper;
    @Override
    public Mapper<PmsProduct> getMapper() {
        return pmsProductMapper;
    }


    public  List<PmsProduct> getSelectAll(Long brandId,String token) {

        boolean b = super.selectToken(token);
        if (b) {
            List<PmsProduct> productList = pmsProductMapper.getSelectAll(brandId);
            if (productList.size() > 0) {
                return productList;
            }
        }
        return null;

    }




}
