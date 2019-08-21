package org.taru.service.two.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.two.HomeDao;
import org.taru.vo.two.Home;
import org.taru.service.two.HomeService;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    HomeDao homeDao;
    /**
     * 查询房源详细信息（包括房东、评论、配置）
     * @return
     */
    @Override
    public List<Home> queryHomeInfo1() {
        return homeDao.queryHomeInfo();
    }

    /**
     * 查询所有房源风格
     * @return
     */
    @Override
    public List<Home> queryHomeStyle1() {
        return homeDao.queryHomeStyle();
    }

    /**
     * 根据ID查询房源详细信息
     * @param homeId
     * @return
     */
    @Override
    public List<Home> queryHomeInfoById1(String homeId) {
        return homeDao.queryHomeInfoById(homeId);
    }

    /**
     * 根据房源ID房源图片（5张），房东信息，房东头像，评论信息
     * @param homeId
     * @return
     */
    @Override
    public List<Home> queryHomeById1(String homeId) {
        return homeDao.queryHomeById(homeId);
    }


}
