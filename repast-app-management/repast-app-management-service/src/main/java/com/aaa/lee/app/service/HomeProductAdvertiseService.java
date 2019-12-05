package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.HomeProductAdvertiseMapper;
import com.aaa.lee.app.vo.HomeProductAdvertiseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Author:RR
 * Description:
 * DATE：2019/11/22
 * PROJECTnNAME:repast-app-parent
 */
@Service
public class HomeProductAdvertiseService extends BaseService<HomeProductAdvertiseVo>{
    @Autowired
    private HomeProductAdvertiseMapper homeProductAdvertiseMapper;
    @Override
    public Mapper<HomeProductAdvertiseVo> getMapper() {
        return homeProductAdvertiseMapper;
    }

    /**
     * 查询广告位图片
     * @return
     */
    public List<HomeProductAdvertiseVo> getAdvertiseList(){
        List<HomeProductAdvertiseVo> advertiseList = homeProductAdvertiseMapper.getAdvertiseList();
       // System.out.println(advertiseList);
        if (advertiseList.size()>0){
            //System.out.println(advertiseList);
            return advertiseList;
        }else {
            return null;
        }
    }
}
