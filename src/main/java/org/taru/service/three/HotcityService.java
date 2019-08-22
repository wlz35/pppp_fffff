package org.taru.service.three;

import org.taru.entity.Story;

import java.util.List;

public interface HotcityService {
    List<Story> hotstorycity();                 //根据点赞量降序前三个城市
}
