package org.taru.service.three.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.three.StoryDao;
import org.taru.entity.Story;
import org.taru.service.three.HotcityService;

import java.util.List;

@Service
public class Hotcityimpl implements HotcityService {
    @Autowired
    StoryDao city;
    @Override
    public List<Story> hotstorycity() {
        return city.hotstorycity();
    }
}
