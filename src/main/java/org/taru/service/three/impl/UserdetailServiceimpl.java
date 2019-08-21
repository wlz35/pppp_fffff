package org.taru.service.three.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.three.OrderDao;
import org.taru.entity.User;
import org.taru.service.three.UserdetailService;

/**
 * 查询用户详情
 */
@Service
public class UserdetailServiceimpl implements UserdetailService {
    @Autowired
    OrderDao user;
    @Override
    public User userdetail(int userId) {
        return user.userdetail(userId);
    }
}
