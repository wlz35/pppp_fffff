package org.taru.service.four.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.four.Guanzhu;
import org.taru.entity.Home;
import org.taru.service.four.HomeService;

@Service
public class HomeServiceimpl implements HomeService {
    @Autowired
    Guanzhu detial;
    @Override
    public Home Homedetail(int id) {
        return detial.Homedetail(id);
    }
}
