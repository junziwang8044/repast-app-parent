package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "pms_comment_replay")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Replay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "member_nick_name")
    private String memberNickName;

    @Column(name = "member_icon")
    private String memberIcon;

    private String content;

    @Column(name = "create_time")
    private String createTime;

    /**
     * 评论人员类型；0->会员；1->管理员
     */
    private Integer type;

}