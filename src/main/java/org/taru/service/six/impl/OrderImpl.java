package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.OrderDao;
import org.taru.entity.Order;
import org.taru.entity.OrderrVo;
import org.taru.service.six.OrderInterface;

import java.util.List;

/**
 * 查询订单service
 */
@Service
public class OrderImpl implements OrderInterface {
    @Autowired
    OrderDao d;


    @Override
    public List<OrderrVo> orderInterface() {
        return d.ordersDao();
    }
}
