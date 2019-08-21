package org.taru.service.three.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.three.OrderDao;
import org.taru.entity.Order;
import org.taru.service.three.QueryorderbyIdService;

@Service
public class Queryorderimpl implements QueryorderbyIdService {
    @Autowired
    OrderDao order;
    @Override
    public Order queryorder(int id) {
        return order.queryorder(id);
    }
}
