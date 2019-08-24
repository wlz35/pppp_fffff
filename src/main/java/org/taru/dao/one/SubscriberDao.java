
package org.taru.dao.one;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.taru.entity.User;

import java.util.List;


@Mapper
@Component
public interface SubscriberDao {

    /**
     * 根据用户名密码查询用户详情
     */
    List<User> queryByUandP(@Param("userName")String userName,
                            @Param("telphone")String telphone);

    /**
     * 根据用户Id查询用户详情
     */
    User queryById(String userId);

    /**
     * 查询所有用户
     */
    List<User> queryUser();

    /**
     * 逻辑删除用户
     * @param userId
     * @return
     */
    int deleteUser(String userId);

    /**
     * 修改用户名密码
     */
    int updateUser(@Param("userName")String userName,
                   @Param("passWord")String passWord,
                   @Param("userId")String userId);



}

