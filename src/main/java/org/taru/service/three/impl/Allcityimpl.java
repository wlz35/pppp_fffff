package org.taru.service.three.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.three.StoryDao;
import org.taru.entity.Story;
import org.taru.service.three.AllstoryService;

import java.util.List;

@Service
public class Allcityimpl implements AllstoryService {
    @Autowired
    StoryDao city;
    @Override
    public List<Story> allstorycity() {
        return city.allstorycity();
    }
}
