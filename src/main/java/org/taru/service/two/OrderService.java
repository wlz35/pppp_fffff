package org.taru.service.two;


import org.taru.vo.two.Order;

public interface OrderService {

    /**
     * 插入订单
     * @param order
     * @return
     */
    int insertOrderCommit1(Order order);

}
