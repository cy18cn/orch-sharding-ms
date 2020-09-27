package com.test.shardingsphere.dao.impl;

import com.airparking.cloud.common.dao.impl.AbstractDAOImpl;
import com.test.shardingsphere.dao.TestDAO;
import com.test.shardingsphere.entity.Test;
import com.test.shardingsphere.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class TestDAOImpl extends AbstractDAOImpl<Test, Long> implements TestDAO {
    @Autowired
    private TestMapper testMapper;

    @Override
    public Mapper<Test> getMapper() {
        return testMapper;
    }

    @Override
    public Test getById(Long id) {
        final Example example = new Example(Test.class);
        example.createCriteria().andEqualTo("id", id).andEqualTo("channel", 1);
//        List<Test> tests = this.testMapper.selectByExample(example);
//        return tests == null || tests.size() == 0 ? null : tests.get(0);
        return this.testMapper.getById(id, null);
    }
}
