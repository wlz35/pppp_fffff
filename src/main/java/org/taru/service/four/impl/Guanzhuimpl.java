package org.taru.service.four.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.four.Guanzhu;
import org.taru.service.four.GuanzhuService;

@Service
public class Guanzhuimpl implements GuanzhuService {


    @Autowired
    Guanzhu gz;

    public int insertdiscussservice(int userid, int goodfrindid) {
        int i = gz.guanzhu(userid, goodfrindid);
        return i;
    }

}