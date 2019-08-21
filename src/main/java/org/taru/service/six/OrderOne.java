package org.taru.service.six;

import org.taru.entity.OrderrVo;

import java.util.List;

/**
 * 根据用户id查订单service
 */
public interface OrderOne {
    List<OrderrVo> orderOneInterface(int id);
}
