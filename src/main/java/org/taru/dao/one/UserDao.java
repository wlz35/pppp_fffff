package org.taru.dao.one;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.taru.entity.User;


@Mapper
@Component
public interface UserDao {

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @libing
     */
    User login(@Param("userName")String userName,@Param("passWord") String passWord);

    /**
     * 用户注册
     * @param user
     * @libing
     */
    int resiger(User user);
}
