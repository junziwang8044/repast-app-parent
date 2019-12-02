package com.aaa.lee.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 李永杰
 * @Date 2019/11/29 16:15
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CanTeenDateVo implements Serializable {
    private Long catId;
    private String catName;
    private List<MemberProduct> data;



}