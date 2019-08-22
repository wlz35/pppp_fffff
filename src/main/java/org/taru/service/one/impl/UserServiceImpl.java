package org.taru.service.one.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.one.UserDao;
import org.taru.entity.User;
import org.taru.service.one.UserService;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   UserDao dao;

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @libing
     */
   public User login(String userName,String passWord){
       return dao.login(userName, passWord);
   }

    /**
     * 用户注册
     * @param user
     * @libing
     */
   public int resiger(User user){
    return dao.resiger(user) ;
   }

}
