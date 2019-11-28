package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.ShopInfoFacility;
import com.aaa.lee.app.mapper.ShopInfoFacilityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Author:RR
 * Description:
 * DATE：2019/11/28
 * PROJECTnNAME:repast-app-parent
 */
@Service
public class ShopInfoFacilityService extends BaseService<ShopInfoFacility> {
    @Autowired
    private ShopInfoFacilityMapper shopInfoFacilityMapper;

    @Override
    public Mapper<ShopInfoFacility> getMapper() {
        return shopInfoFacilityMapper;
    }

    /**
     * 通过店铺主键查询店铺内提供的服务
     * @param shopId
     * @return
     */
    public List<ShopInfoFacility> getServerByShopId(Long shopId){
        List<ShopInfoFacility> serverByShopId = shopInfoFacilityMapper.getServerByShopId(shopId);
        if (null != serverByShopId){
            return serverByShopId;
        }else {
            return null;
        }
    }
}
