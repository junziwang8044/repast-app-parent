package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.DeleteHistorySearch;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.mapper.DeleteHistorySearchMapper;
import com.aaa.lee.app.mapper.MemberMapper;
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
public class DeleteHistorySearchService extends BaseService<Member> {

    @Autowired
    private DeleteHistorySearchMapper deleteHistorySearchMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public Mapper<Member> getMapper() {
        return memberMapper;
    }

    /**
     * 删除某个用户的历史搜索
     * @param
     * @return
     */
    public  Boolean getdeleteHistorySearch(String token){
        if(null!=token){
            Member m = new Member();
            Member member = getMapper().selectOne(m.setToken(token));
            if (null!=member){
                Long id = member.getId();
                int i = deleteHistorySearchMapper.deleteHistorySearch(id);
                if(i>0){
                    return true;
                }
            }
        }
       return false;
    }
}
