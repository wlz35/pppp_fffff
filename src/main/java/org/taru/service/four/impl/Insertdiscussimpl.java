package org.taru.service.four.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.four.InserdiscusDao;
import org.taru.service.four.InsertdiscussService;

@Service
public class Insertdiscussimpl implements InsertdiscussService {
    @Autowired
    InserdiscusDao insert;
    public int insertdiscussservice(String discusstext,int homeid,int userid){
        int i=insert.insertdiscuss(discusstext,homeid,userid);
        return i;
    }

}
