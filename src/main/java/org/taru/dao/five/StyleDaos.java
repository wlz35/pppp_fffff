package org.taru.dao.five;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.taru.entity.Style;

import java.util.List;

@Mapper
@Repository
public interface StyleDaos {
    //查询风格（style）的说有信息
    List queryStyleDao();
    //添加风格（style）
    int addStyleDao(Style style);
    //根据ID修改风格
    int updateStyleDao(Style style);
    //根据ID逻辑删除
    int deleteStyleDao(int styleId);
}
