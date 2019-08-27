package org.taru.service.three;

import org.taru.entity.Order;

import java.util.List;

/**
 * 根据用户Id查询订单详情
 */
public interface QueryorderbyIdService {
    List<Order> queryorder(int UserId);
}
