package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.ShareSixDao;
import org.taru.entity.HomeCollection;
import org.taru.service.six.CollectionQuaryInterface;

import java.util.List;
@Service
public class CollectionQuaryImpl implements CollectionQuaryInterface {
    @Autowired
    ShareSixDao s;
    @Override
    public List<HomeCollection> collectionQuary(int id) {
        return s.collectionQuary(id);
    }
}
