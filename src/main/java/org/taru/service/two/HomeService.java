package org.taru.service.two;

import org.taru.vo.two.Home;

import java.util.List;

public interface HomeService {
    /**
     * 查询房源详细信息（包括房东、评论、配置）
     * @return
     */
    List<Home> queryHomeInfo1();

    /**
     * 查询所有房源风格
     * @return
     */
    List<Home> queryHomeStyle1();

    /**
     * 根据ID查询房源详细信息
     * @param homeId
     * @return
     */
    List<Home> queryHomeInfoById1(String homeId);

    /**
     * 根据房源ID房源图片（5张），房东信息，房东头像，评论信息
     * @param homeId
     * @return
     */
    List<Home> queryHomeById1(String homeId);



}
