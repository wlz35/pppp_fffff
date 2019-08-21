package org.taru.service.three.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.three.AddHomeDao;
import org.taru.service.three.AddhomeService;

@Service
public class Addhomeimpl implements AddhomeService {
    @Autowired
    AddHomeDao home1;
    @Override
    public int addhome(String styleName,String homeName,String homeAddress
            ,String homePrice,String home_in_Date,String home_out_Date,String picturesId,String homeDescribe,String homeSpot,String homeConfigure,
                       String landlordPhone) {
        return home1.addhome(styleName,homeName,homeAddress,homePrice,home_in_Date,home_out_Date,picturesId,homeDescribe,homeSpot,homeConfigure,
                landlordPhone);
    }
}
