package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.ShareSixDao;
import org.taru.entity.UserRelationVo;
import org.taru.service.six.ShareSixInterface;

import java.util.List;
@Service
public class ShareSixImpl implements ShareSixInterface {
    @Autowired
    ShareSixDao s;
    @Override
    public List<UserRelationVo> shareSixDao(int id) {
        return s.shareoneSixDao(id);
    }
}
