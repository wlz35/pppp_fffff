package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.OrdersSixDao;
import org.taru.entity.OrderrVo;
import org.taru.service.six.OrderOne;

import java.util.List;

/**
 * 根据用户id查 impl
 */
@Service
public class OrderOneImpl implements OrderOne {
    @Autowired
    OrdersSixDao d;
    @Override
    public List<OrderrVo> orderOneInterface(int id) {
        return d.ordersOneDao(id);
    }
}
