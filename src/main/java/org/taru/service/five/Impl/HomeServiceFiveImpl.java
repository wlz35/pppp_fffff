package org.taru.service.five.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.five.HomeDaos;
import org.taru.entity.Home;
import org.taru.service.five.HomeService;

import java.util.List;


/**
 * 房源的增删改查
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    HomeDaos impl;
    //查询所有房源
        public List queryHomeService(){
        List list = impl.QueryHomeDao();
            return list;
        }

        //添加房源信息
//        public int addHomeService(Home home){
//          int row = impl.addHomeDao(home);
//            return row;
//        }
        //根据房源ID（home_id）逻辑删除房源信息
        public int deleteHomeService(int homeId){
          int row = impl.deleteHomeDao(homeId);
          return row;
        }
        //根据房源ID修改房源信息
        public int updateHomeService(Home home){
          int row =  impl.updateHomeDao(home);
          return row;
        }
}
