package org.taru.service.three.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.three.OrderDao;
import org.taru.entity.Order;
import org.taru.service.three.QueryorderbyIdService;

import java.util.List;

/**
 * 根据用户Id查询订单详情
 */
@Service
public class Queryorderimpl implements QueryorderbyIdService {
    @Autowired
    OrderDao order;
    @Override
    public List<Order> queryorder(int UserId) {
        return order.queryorder(UserId);
    }
}
