package org.taru.service.three.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.three.StoryDao;
import org.taru.service.three.ClickService;

/**
 * 用户点赞
 */
@Service
public class Clickimpl implements ClickService {
    @Autowired
    StoryDao click;
    @Override
    public int clik(int storyId) {
        return click.clik(storyId);
    }
}
