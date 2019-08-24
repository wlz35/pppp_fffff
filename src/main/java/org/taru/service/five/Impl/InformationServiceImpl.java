package org.taru.service.five.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.five.InformationDao;
import org.taru.service.five.InformationService;

import java.util.List;


@Service
public class InformationServiceImpl implements InformationService {
//根据用户ID查消息
    @Autowired
    InformationDao impl;
    public List queryInforByUserIdService(int userId){
          List list =  impl.queryInforByUserIdDao(userId);
        return list;
    }
}
