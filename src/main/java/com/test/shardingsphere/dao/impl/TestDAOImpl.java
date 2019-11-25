package com.test.shardingsphere.dao.impl;

import com.airparking.cloud.common.dao.impl.AbstractDAOImpl;
import com.test.shardingsphere.dao.TestDAO;
import com.test.shardingsphere.entity.ClazzS;
import com.test.shardingsphere.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public class TestDAOImpl extends AbstractDAOImpl<ClazzS, Long> implements TestDAO {
    @Autowired
    private TestMapper testMapper;

    @Override
    public Mapper<ClazzS> getMapper() {
        return testMapper;
    }
}
