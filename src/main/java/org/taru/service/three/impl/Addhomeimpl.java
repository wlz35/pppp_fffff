package org.taru.service.three.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.three.AddHomeDao;
import org.taru.entity.AddHome;
import org.taru.entity.Pictures;
import org.taru.service.three.AddhomeService;

@Service
public class Addhomeimpl implements AddhomeService {
    @Autowired
    AddHomeDao a;
    @Override
    public int addhome(String styleName,String homeName,String homeAddress
            ,String homePrice,String homeInDate,String homeOutDate,String pictureOne,String pictureTwo,String pictureThree,String pictureFour,String pictureFive,String homeDescribe,String homeSpot,String homeConfigure,
                       String landlordPhone) {
        Pictures p=new Pictures();
        p.setPictureOne(pictureOne);
        p.setPictureTwo(pictureTwo);
        p.setPictureThree(pictureThree);
        p.setPictureFour(pictureFour);
        p.setPictureFive(pictureFive);


        int i=a.addPicture(p);
        String picturesId=String.valueOf(p.getPictureId());
        System.out.println(picturesId);
        AddHome s=new AddHome();
        s.setStyleName(styleName);
        s.setHomeAddress(homeAddress);
        s.setHomeName(homeName);
        s.setHomePrice(homePrice);
        s.setHomeInDate(homeInDate);
        s.setHomeOutDate(homeOutDate);
        s.setPicturesId(picturesId);
        s.setHomeDescribe(homeDescribe);
        s.setHomeSpot(homeSpot);
        s.setHomeConfigure(homeConfigure);
        s.setLandlordPhone(landlordPhone);
        int j=a.addhome(s);
        int x=0;
        if(j!=0&&i!=0){
            x=1;
        }

        return x;
    }
}
