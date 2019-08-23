package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.ShareSixDao;
import org.taru.service.six.ShareUpdatenterface;

@Service
public class ShareUpdateImpl implements ShareUpdatenterface {
    @Autowired
    ShareSixDao s;

    @Override
    public int shareDao(int relationId, int homeId) {
        return s.shareDao(relationId,homeId);
    }
}
