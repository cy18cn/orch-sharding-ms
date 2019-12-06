package com.test.shardingsphere.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "sbtest1")
public class Test implements Serializable {
    // id
    @Id
    private Long id;
    // parkNo
    @Column(name = "k")
    private Integer k;
    // 长租开始时间
    @Column(name = "c")
    private String c;

    // 长租开始时间
    @Column(name = "pad")
    private String pad;
}
