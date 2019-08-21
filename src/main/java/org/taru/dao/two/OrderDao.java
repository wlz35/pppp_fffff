package org.taru.dao.two;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.taru.vo.two.Order;

@Mapper
@Component("orderMapper")
public interface OrderDao {

    /**
     * 插入订单
     * @param order
     * @return
     */
    int insertOrderCommit(Order order);
}
