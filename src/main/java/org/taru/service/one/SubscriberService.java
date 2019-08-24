package org.taru.service.one;

import org.taru.entity.User;
import java.util.List;

public interface SubscriberService {

    /**
     * 根据用户名密码查询用户详情
     */
    List<User> queryByUandP(String userName,String telphone);

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
    int updateUser(String userName,String passWord,String userId);


}
