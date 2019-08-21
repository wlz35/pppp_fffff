package org.taru.service.two.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.two.OrderDao;
import org.taru.vo.two.Order;
import org.taru.service.two.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    /**
     * 插入订单
     * @param order
     * @return
     */
    @Override
    public int insertOrderCommit1(Order order) {
        return orderDao.insertOrderCommit(order);
    }
}
