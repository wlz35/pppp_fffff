package org.taru.dao.one;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.taru.entity.Home;

import javax.xml.crypto.Data;
import java.util.List;

@Mapper
@Component
public interface HomeDao  {

    /**
     * 根据城市/景点/时间查询房源/多条件查询/分页
     * 返回房源信息，房东信息，图片信息，评价信息
     * @libing
     */
    List<Home>  queryByCityAndSpot(@Param("homeAddress") String homeAddress,
                                   @Param("homeSpot") String homeSpot,
                                   @Param("homeInDate") String homeInDate,
                                   @Param("homeOutDate")String homeOutDate );

    /**
     * 根据风格查询房源信息/分页
     * @Param styleName
     * @libing
     */
    List<Home>  queryByStyle(String styleName);

    /**
     * 根据城市查询/点赞降序/分页
     * 返回所有房源信息
     */
    List<Home> queryByCity(String homeAddress);
}
