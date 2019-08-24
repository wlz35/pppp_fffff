package org.taru.dao.five;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.taru.entity.Home;

import java.util.List;
@Mapper
@Repository
public interface HomeDaos {
    //查询所有房源
    List QueryHomeDao();

    //添加房源信息
//    int addHomeDao(Home home);

    //根据房源ID（home_id）逻辑删除房源信息
    int deleteHomeDao(int homeId);
    //根据房源ID修改房源信息
    int updateHomeDao(Home home);

}
