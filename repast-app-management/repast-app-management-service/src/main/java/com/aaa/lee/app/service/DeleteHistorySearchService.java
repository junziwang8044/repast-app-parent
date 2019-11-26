package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.DeleteHistorySearch;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.mapper.DeleteHistorySearchMapper;
import com.aaa.lee.app.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import static com.aaa.lee.app.staticstatus.StaticProperties.REDIS_KEY;

/**
 * @Author 李永杰
 * @Date 2019/11/23 20:41
 **/
@Service
public class DeleteHistorySearchService extends BaseService<DeleteHistorySearch> {

    @Autowired
    private DeleteHistorySearchMapper deleteHistorySearchMapper;
    @Override
    public Mapper<DeleteHistorySearch> getMapper() {
        return deleteHistorySearchMapper;
    }

    /**
     * 删除某个用户的历史搜索
     * @param redisService
     * @return
     */
    public  Boolean getdeleteHistorySearch(RedisService redisService){
        String member = redisService.get(REDIS_KEY);
        try {
            Member m = JSONUtil.toObject(member, Member.class);
            if(null!=m){
                Long id = m.getId();
                int i = deleteHistorySearchMapper.deleteHistorySearch(id);
                if(i>0){
                    return true;
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

       return false;
    }
}
