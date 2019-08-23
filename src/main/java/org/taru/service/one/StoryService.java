package org.taru.service.one;

import org.taru.vo.one.Storyss;

import java.util.List;

public interface StoryService {

    /**
     * 查询所有故事
     * 返回图片等相关信息
     * @libing
     */
    List<Storyss> queryAllStory();

    /**
     * 根据城市查询故事
     * 返回图片等相关信息
     * @libing
     */
    List<Storyss> queryStoryByCity(String storyCity);

    /**
     * 根据故事Id查询故事详情
     * @libing
     */
    Storyss queryStoryById(String storyId);
}
