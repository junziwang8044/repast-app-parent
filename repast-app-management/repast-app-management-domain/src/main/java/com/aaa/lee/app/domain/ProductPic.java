package com.aaa.lee.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Table(name = "pms_album_pic")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductPic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "album_id")
    private Long albumId;

    private String pic;

}