package org.taru.dao.three;

import org.apache.ibatis.annotations.Mapper;
import org.taru.entity.Order;
import org.taru.entity.User;

/**
 * 用户和订单查询
 */
@Mapper
public interface OrderDao {
    Order queryorder(int id);            //查询单个订单详情
    User hosityorder(int userId);       //查询用户历史订单
    User userdetail(int userId);         //查询用户详情
}
