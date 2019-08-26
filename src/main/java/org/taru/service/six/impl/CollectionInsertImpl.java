package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.ShareSixDao;
import org.taru.service.six.CollectionInsertInterface;
@Service
public class CollectionInsertImpl implements CollectionInsertInterface {
    @Autowired
    ShareSixDao s;
    @Override
    public int collectionInsert(int userId, int homeId) {
        return s.collectionInsert(userId,homeId);
    }
}
