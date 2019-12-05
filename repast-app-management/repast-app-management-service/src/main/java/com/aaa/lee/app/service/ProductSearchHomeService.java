package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.DeleteHistorySearch;
import com.aaa.lee.app.domain.Member;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.mapper.DeleteHistorySearchMapper;
import com.aaa.lee.app.mapper.MemberMapper;
import com.aaa.lee.app.mapper.ProductSearchHomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author 李永杰
 * @Date 2019/11/22 16:46
 **/
@Service
public class ProductSearchHomeService extends BaseService<Member> {

    @Autowired
    private ProductSearchHomeMapper productSearchHomeMapper;

    @Autowired
    private DeleteHistorySearchMapper deleteHistorySearchMapper;

    @Autowired
    private MemberMapper memberMapper;
    @Override
    public Mapper<Member> getMapper() {
        return memberMapper;
    }
    /**
     * 首页搜索
     * @param name
     * @return
     */
    public List<Product> getSearchHome(String name,String token){

        boolean b = selectToken(token);
        if (b){
            if(null!=name){
                Member m = new Member();
                Member member = getMapper().selectOne(m.setToken(token));
                if(null!=member) {
                    Long id = member.getId();
                    DeleteHistorySearch Search = new DeleteHistorySearch();
                    Search.setMemberId(id);
                    Search.setHistorySearchName(name);
                    int i = deleteHistorySearchMapper.insertSearch(Search);
                    if(i>0) {
                        name = ("%" + name + "%");
                    }else {
                        return null;
                    }
            } else {
                name=("%%");
            }
            List<Product> products = productSearchHomeMapper.selectProductSearchHome(name);

                if (products.size() > 0) {
                    return products;
                }
            }
        }
        return null;
    }

}
