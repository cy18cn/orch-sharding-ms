package com.test.shardingsphere.service.impl;

import com.airparking.cloud.common.dao.AbstractDAO;
import com.airparking.cloud.common.impl.AbstractServiceImpl;
import com.test.shardingsphere.dao.TestDAO;
import com.test.shardingsphere.entity.Test;
import com.test.shardingsphere.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl extends AbstractServiceImpl<Test, Long> implements TestService {
    @Autowired
    private TestDAO testDAO;

    @Override
    public AbstractDAO<Test, Long> getAbstractDAO() {
        return testDAO;
    }

    @Override
    @Transactional
    public Integer add(Test test) {
        this.testDAO.insertSelective(test);
        throw new RuntimeException();
//        return 1;
    }
}
