package org.taru.service.one.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.one.SubscriberDao;
import org.taru.entity.User;
import org.taru.service.one.SubscriberService;
import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    SubscriberDao dao;
    /**
     * 根据用户名密码查询用户详情
     */
    public List<User> queryByUandP(String userName,String telphone){
        return dao.queryByUandP(userName, telphone);
    };

    /**
     * 根据用户Id查询用户详情
     */
    public User queryById(String userId){
        return dao.queryById(userId);
    }

    /**
     * 查询所有用户
     */
    public List<User> queryUser(){
        return dao.queryUser();
    }

    /**
     * 逻辑删除用户
     * @param userId
     * @return
     */
    public int deleteUser(String userId){
        return dao.deleteUser(userId);
    }

    /**
     * 修改用户名密码
     */
    public int updateUser(String userName,String passWord,String userId){
        return dao.updateUser(userName, passWord,userId);
    }



}
