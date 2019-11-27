package com.aaa.lee.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:RR
 * Description:
 * DATE：2019/11/22
 * PROJECTnNAME:repast-app-parent
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HomeProductAdvertiseVo implements Serializable {

    private String shopName;
    private String positionName;
    private String descrition;
    private Integer maxCount;
    private String pic;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date startTime;
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date endTime;
    //上下线状态：0下线 1上线
    private Integer status;
    //点击数
    private Integer clickCount;
    //下单数
    private Integer orderCount;
    private Integer type;
    //链接地址
    private String url;
    //排序
    private Integer sort;
}
