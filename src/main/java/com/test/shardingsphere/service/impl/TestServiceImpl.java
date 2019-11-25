package com.test.shardingsphere.service.impl;

import com.airparking.cloud.common.dao.AbstractDAO;
import com.airparking.cloud.common.impl.AbstractServiceImpl;
import com.test.shardingsphere.dao.TestDAO;
import com.test.shardingsphere.entity.ClazzS;
import com.test.shardingsphere.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl extends AbstractServiceImpl<ClazzS, Long> implements TestService {
    @Autowired
    private TestDAO testDAO;

    @Override
    public AbstractDAO<ClazzS, Long> getAbstractDAO() {
        return testDAO;
    }

    @Override
    @Transactional
    public Integer add(ClazzS clazzS) {
        this.testDAO.insert(clazzS);
//        throw new RuntimeException();
        return 1;
    }
}
