package org.taru.service.one;

import org.taru.entity.User;

public interface UserService {
    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @libing
     */
    User login(String userName,String passWord);

    /**
     * 用户注册
     * @param user
     * @libing
     */
    int resiger(User user);
}
