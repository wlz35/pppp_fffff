package org.taru.service.three.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.taru.dao.three.OrderDao;
import org.taru.entity.Order;
import org.taru.entity.User;
import org.taru.service.three.HistoryorderService;

/**
 * 查询用户历史订单
 */
@Service
public class HistoryorderServiceimpl implements HistoryorderService{
    @Autowired
    OrderDao user;
    @Override
    public User historyorder(int userId) {
        return user.hosityorder(userId);
    }
}
