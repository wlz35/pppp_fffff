package org.taru.dao.two;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.taru.vo.two.Home;
import org.taru.vo.two.Order;

@Mapper
@Component("orderMapper")
public interface OrderTwoDao {

    /**
     * 插入订单
     * @param order
     * @return
     */
    int insertOrderCommit(Order order);






}
