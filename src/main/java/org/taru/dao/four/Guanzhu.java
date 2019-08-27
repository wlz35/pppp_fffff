package org.taru.dao.four;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.taru.entity.Home;

@Mapper
@Repository
public interface Guanzhu {
    int guanzhu(int userid, int goodfriendid);
    Home Homedetail(int id);
}
