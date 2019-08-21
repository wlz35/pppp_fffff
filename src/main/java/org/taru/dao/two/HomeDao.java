package org.taru.dao.two;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.taru.vo.two.Home;

import java.util.List;

@Mapper
@Component("HomeMapper")
public interface HomeDao {
    /**
     * 查询房源详细信息（包括房东、评论、配置）
     * @return
     */
    List<Home> queryHomeInfo();

    /**
     * 查询所有房源风格
     * @return
     */
    List<Home> queryHomeStyle();

    /**
     * 根据ID查询房源详细信息
     * @param homeId
     * @return
     */
    List<Home> queryHomeInfoById(String homeId);

    /**
     * 根据房源ID房源图片（5张），房东信息，房东头像，评论信息
     * @param homeId
     * @return
     */
    List<Home> queryHomeById(String homeId);

//    /**
//     * 查询价格
//     * @param homeId
//     * @return
//     */
//    int queryPrice(int homeId);
}
