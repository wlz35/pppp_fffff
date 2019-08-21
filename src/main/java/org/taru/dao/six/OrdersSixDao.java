package org.taru.dao.six;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.taru.entity.Order;
import org.taru.entity.OrderrVo;

import java.util.HashMap;
import java.util.List;

/**
 * 订单增删改
 */
@Repository
@Mapper
public interface OrdersSixDao {
    /**
     * 查询所有订单
     * @return
     */
    List<OrderrVo> ordersDao();

    /**
     * 根据用户id查询订单
     * @param id
     * @return
     */
    List<OrderrVo> ordersOneDao(int id);

    /**
     * 修改订单
     * @param hashMap
     * @return
     */
    int orderModify(HashMap hashMap);
    /**
     * 删除订单
     * @param id
     * @return
     */
    int orderdelete(int id);
}
