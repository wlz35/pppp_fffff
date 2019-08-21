package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.SearchTwoDao;
import org.taru.entity.HomeLandlordStyleVO;
import org.taru.service.six.SearchTwoInterface;

import java.util.HashMap;
import java.util.List;
/**
        * 根据时间，房源风格，地点，景点 查房源信息房东信息
        */
@Service
public class SearchTwoImpl implements SearchTwoInterface {
    @Autowired
    SearchTwoDao d;
    @Override
    public List<HomeLandlordStyleVO> searchTwoDao(HashMap hashMap) {
        return d.searchTwoDao(hashMap);
    }
}
