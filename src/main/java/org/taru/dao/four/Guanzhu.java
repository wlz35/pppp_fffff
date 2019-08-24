package org.taru.dao.four;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Guanzhu {
    int guanzhu(int userid,int goodfriendid);
}
