package org.taru.service.one.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.one.StoryDao;
import org.taru.service.one.StoryService;
import org.taru.vo.one.Storyss;
import java.util.List;


@Service
public class StoryServiceImpl implements StoryService {
    @Autowired
    StoryDao dao;

    /**
     * 查询所有故事
     * 返回图片等相关信息
     */
    public List<Storyss> queryAllStory(){
        return dao.queryAllStory();
    };

    /**
     * 根据城市查询故事
     * 返回图片等相关信息
     */
    public List<Storyss> queryStoryByCity(String storyCity){
        return dao.queryStoryByCity(storyCity);
    };

    /**
     * 根据故事Id查询故事详情
     * @libing
     */
    public Storyss queryStoryById(String storyId){
        return dao.queryStoryById(storyId);
    };
}
