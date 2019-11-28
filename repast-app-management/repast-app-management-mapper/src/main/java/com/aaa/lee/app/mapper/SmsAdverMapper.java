package com.aaa.lee.app.mapper;


import com.aaa.lee.app.domain.SmsAdver;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SmsAdverMapper extends Mapper<SmsAdver> {

    List<SmsAdver> shopIdList(Long shopId);


}