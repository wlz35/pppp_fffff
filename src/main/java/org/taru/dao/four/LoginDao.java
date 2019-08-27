package org.taru.dao.four;


import org.apache.ibatis.annotations.Mapper;
import org.taru.entity.Admin;
@Mapper
public interface LoginDao {
    Admin login(String name, String password);
}
