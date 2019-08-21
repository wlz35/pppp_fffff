package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.OrderDao;
import org.taru.entity.Order;
import org.taru.service.six.OrderModifyInterface;

import java.util.HashMap;

/**
 * 修改订单impl
 */
@Service
public class OrderModifyImpl implements OrderModifyInterface {
    @Autowired
    OrderDao d;
    @Override
    public int orderModifyInterface(HashMap hashMap) {
        return d.orderModify(hashMap);
    }
}
