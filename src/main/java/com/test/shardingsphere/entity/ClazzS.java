package com.test.shardingsphere.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "s")
public class ClazzS implements Serializable {
    // id
    @Id
    private Long id;
    // parkNo
    @Column(name = "content")
    private String content;
    // 长租开始时间
    @Column(name = "created_at")
    private Date createdAt;
}
