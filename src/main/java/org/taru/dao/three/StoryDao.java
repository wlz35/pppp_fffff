package org.taru.dao.three;

import org.apache.ibatis.annotations.Mapper;
import org.taru.entity.Story;

import java.util.List;

@Mapper
public interface StoryDao {
    List<Story> allstorycity();                 //查询所有故事城市
    List<Story> hotstorycity();                 //根据点赞量降序前三个城市
    int clik(int storyId);                //故事点赞
}
