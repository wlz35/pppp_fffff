package org.taru.service.five;

import org.taru.entity.Style;

import java.util.List;

public interface StyleService {
    //查询风格（style）的所有信息
    List queryStyleService();
    //添加风格（style）
    int addStyleService(Style style);
    //根据ID修改风格
    int updateStyleService(Style style);
    //根据ID逻辑删除
    int deleteStyleService(int styleId);
}
