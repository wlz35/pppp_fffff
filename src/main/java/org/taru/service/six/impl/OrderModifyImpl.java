package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.OrdersSixDao;
import org.taru.service.six.OrderModifyInterface;

import java.util.HashMap;

/**
 * 修改订单impl
 */
@Service
public class OrderModifyImpl implements OrderModifyInterface {
    @Autowired
    OrdersSixDao d;
    @Override
    public int orderModifyInterface(HashMap hashMap) {
        return d.orderModify(hashMap);
    }
}
