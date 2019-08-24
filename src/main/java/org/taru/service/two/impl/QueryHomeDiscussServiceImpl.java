package org.taru.service.two.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.two.QueryHomeDiscussDao;
import org.taru.service.two.QueryHomeDiscussService;
import org.taru.vo.two.Home;

import java.util.List;

@Service
public class QueryHomeDiscussServiceImpl implements QueryHomeDiscussService {
    @Autowired
    QueryHomeDiscussDao queryHomeDiscussDao;

    @Override
    public List<Home> queryHomeDiscuss1(String homeId) {
        return queryHomeDiscussDao.queryHomeDiscuss(homeId);
    }
}
