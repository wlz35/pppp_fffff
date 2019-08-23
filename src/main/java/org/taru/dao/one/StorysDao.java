package org.taru.dao.one;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.taru.vo.one.Storyss;
import java.util.List;

@Mapper
@Component
public interface StorysDao {

    /**
     * 查询所有故事
     * 返回图片等相关信息
     * libing
     */
    List<Storyss> queryAllStory();

    /**
     * 根据城市查询故事
     * 返回图片等相关信息
     * libing
     */
    List<Storyss> queryStoryByCity(String storyCity);

    /**
     * 根据故事Id查询故事详情
     * libing
     */
    Storyss queryStoryById(String storyId);
}
