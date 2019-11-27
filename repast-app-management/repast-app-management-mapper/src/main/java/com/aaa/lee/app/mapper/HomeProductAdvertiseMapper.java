package com.aaa.lee.app.mapper;

import com.aaa.lee.app.vo.HomeProductAdvertiseVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Author:RR
 * Description:
 * DATE：2019/11/22
 * PROJECTnNAME:repast-app-parent
 */
public interface HomeProductAdvertiseMapper extends Mapper<HomeProductAdvertiseVo> {
    //轮播广告
    List<HomeProductAdvertiseVo> getAdvertiseList();

}
