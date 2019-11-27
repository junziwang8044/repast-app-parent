package com.aaa.lee.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Author:RR
 * Description:
 * DATE：2019/11/23
 * PROJECTnNAME:repast-app-project
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductHotBySale implements Serializable {
    private String name;
    private String description;
    private BigDecimal originalPrice;
    private BigDecimal price;
    private String productSn;
    private Date promotionStartTime;
    private BigDecimal weight;
    private BigDecimal promotionPrice;
    private Integer giftPoint;
    private Integer stock;
    private String address;
    private String assess;
    private String openTime;
    private String name2;
    private Integer picCount;
    private String des;
    private String pic;
    private String images;
    private String pic2;
}
