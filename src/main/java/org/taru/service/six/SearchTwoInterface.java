package org.taru.service.six;

import org.taru.entity.HomeLandlordStyleVO;

import java.util.HashMap;
import java.util.List;

/**
 * 根据时间，房源风格，地点，景点 查房源信息房东信息
 */
public interface SearchTwoInterface {
    List<HomeLandlordStyleVO> searchTwoDao(HashMap hashMap);
}
