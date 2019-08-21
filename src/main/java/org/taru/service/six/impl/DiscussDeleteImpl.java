package org.taru.service.six.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.DiscussDao;
import org.taru.service.six.DisscussDeleteInterface;
@Service
public class DiscussDeleteImpl implements DisscussDeleteInterface {
    @Autowired
    DiscussDao d;
    @Override
    public int discussDeleteInterface(int id) {
        return d.discussDelete(id);
    }
}
