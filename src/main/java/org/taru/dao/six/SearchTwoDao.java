package org.taru.dao.six;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.taru.entity.Home;
import org.taru.entity.HomeLandlordStyleVO;
import org.taru.entity.Style;

import java.util.HashMap;
import java.util.List;

/**
 * 根据时间，房源风格，地点，景点 查房源信息房东信息
 */
@Repository
@Mapper
public interface SearchTwoDao {
    List<HomeLandlordStyleVO> searchTwoDao(HashMap hashMap);
    List<Style> styleDao();
    List<Home> address();
}
