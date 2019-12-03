package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.SmsAdver;
import com.aaa.lee.app.mapper.SmsAdverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public class SmsAdverService extends BaseService<SmsAdver> {


    @Autowired
    private SmsAdverMapper smsAdverMapper;

    @Override
    public Mapper<SmsAdver> getMapper() {
        return smsAdverMapper;
    }

    public List<SmsAdver> shopIdList(Long shopId, String token) {

        List<SmsAdver> smsAdvers = smsAdverMapper.shopIdList(shopId);
        if (smsAdvers.size() > 0) {
            return smsAdvers;
        } else {
            return null;
        }

    }
}
