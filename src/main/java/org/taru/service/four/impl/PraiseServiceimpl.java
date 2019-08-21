package org.taru.service.four.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.four.PraiseDao;
import org.taru.service.four.PraiseService;
@Service
public class PraiseServiceimpl implements PraiseService {
@Autowired
    PraiseDao pr;
public int praiseservice(int homeid){
    int m=pr.praisedao(homeid);
    return m;
}


}
