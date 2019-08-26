package org.taru.service.five.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.five.OrderDaos;
import org.taru.service.five.OrderFiveService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrderFiveServiceImpl implements OrderFiveService{
    @Autowired
    OrderDaos impl;
    public int queryMoney(int userId,int homeId, String homeInDate, String homeOutDate) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date inDate = df.parse(homeInDate);
        Date outDate=df.parse(homeOutDate);
        long diff = outDate.getTime() - inDate.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        int oneDayPrice = impl.selectPriceById(homeId);
        int orderPrice= (int)(oneDayPrice*days);
        impl.insertOrderDao(homeId,userId,orderPrice,homeInDate,homeOutDate);
        return orderPrice;
    }
}
