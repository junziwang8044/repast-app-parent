package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.ShopInfo;
import com.aaa.lee.app.mapper.ShopInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author hxx
 * @Date Create in 2019/11/21 11:00
 * @Description
 **/
@Service
public class ShopInfoService extends BaseService<ShopInfo> {

    @Autowired
    private ShopInfoMapper shopInfoMapper;

    @Override
    public Mapper<ShopInfo> getMapper() {
        return shopInfoMapper;
    }

    /**
     * @author hxx
     * @description
     *      通过店铺主键查询店铺信息(包装类型)
     * @param [shopId]
     * @date 2019/11/21
     * @return java.util.List<com.aaa.lee.app.vo.ShopInfoVo>
     * @throws 
    **/
    public ShopInfo getShopInfoByShopId(Long shopId,String token) {
        boolean boo = selectToken(token);
        if (boo){
        ShopInfo shopInfoByShopId = shopInfoMapper.getShopInfoByShopId(shopId);
        return shopInfoByShopId;
        }
        return null;
    }

    /**
     * 点击店铺，获取店铺信息
     */
    public List<ShopInfo> touchShopByShopId(Long shopId,String token){
        boolean boo = selectToken(token);
        if (boo) {
            List<ShopInfo> touchshopInfos = shopInfoMapper.touchShopByShopId(shopId);
            if (touchshopInfos.size() > 0) {
                return touchshopInfos;
            }
        }
        return null;
    }
    /**
     * @author hxx
     * @description
     *      通过店铺主键查询店铺信息(包装类型)
     * @param [shopId]
     * @date 2019/11/21
     * @return java.util.List<com.aaa.lee.app.vo.ShopInfoVo>
     * @throws
     **/
    public ShopInfo getShopMsgById(Long shopId,String token) {
        boolean boo = selectToken(token);
        if (boo) {
            ShopInfo shopInfoByShopId = shopInfoMapper.getShopInfoByShopId(shopId);
            return shopInfoByShopId;
        }
        return null;
    }

}
