package org.taru.service.five;

import org.taru.entity.Home;

import java.util.List;

public interface HomeService {
    //查询所有房源
    List  queryHomeService();
    //添加房源信息
//    int addHomeService(Home home);
    //根据房源ID（home_id）逻辑删除房源信息
    int deleteHomeService(int homeId);
    //根据房源ID修改房源信息
    int  updateHomeService(Home home);
}
