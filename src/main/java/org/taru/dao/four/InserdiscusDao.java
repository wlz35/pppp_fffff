package org.taru.dao.four;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InserdiscusDao {
    int insertdiscuss(String discusstext,int homeid,int userid);
}
