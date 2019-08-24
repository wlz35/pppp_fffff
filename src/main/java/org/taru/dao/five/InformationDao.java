package org.taru.dao.five;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface InformationDao {
    //根据用户ID查消息
    List queryInforByUserIdDao(int userId);
}
