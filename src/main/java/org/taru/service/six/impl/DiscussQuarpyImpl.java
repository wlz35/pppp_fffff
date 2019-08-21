package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.DiscussDao;
import org.taru.entity.DIscussHomeVo;
import org.taru.service.six.DiscussQuaryInterface;

import java.util.List;
@Service
public class DiscussQuarpyImpl implements DiscussQuaryInterface {
@Autowired
    DiscussDao d;
    @Override
    public List<DIscussHomeVo> discussQuaryInterface() {
        return d.discussQuary();
    }
}
