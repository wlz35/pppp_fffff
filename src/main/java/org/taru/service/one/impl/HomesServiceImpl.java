package org.taru.service.one.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.one.HomesDao;
import org.taru.entity.Home;
import org.taru.service.one.HomesService;

import java.util.List;

@Service
public class HomesServiceImpl implements HomesService {

    @Autowired
    HomesDao dao;

    /**
     * 根据城市/景点/时间查询房源/多条件查询/分页
     * 返回房源信息，房东信息，图片i信息，评价信息
     * @param homeAddress
     * @param homeSpot
     * @libing
     */
    public List<Home> queryByAandS(String homeAddress, String homeSpot, String homeInDate, String homeOutDate){

        return dao.queryByCityAndSpot(homeAddress, homeSpot,homeInDate,homeOutDate);
    }


    /**
     * 根据风格查询房源信息
     * @param styleName
     * @libing
     */
    public List<Home> queryByStyle(String styleName){
        return dao.queryByStyle(styleName);
    }


    /**
     * 根据城市查询/点赞降序/分页
     * 返回所有房源信息
     */
    public List<Home> queryByCity(String homeAddress){
        return dao.queryByCity(homeAddress);
    };

}
