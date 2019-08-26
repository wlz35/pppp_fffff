package org.taru.service.five;

import java.text.ParseException;

public interface OrderFiveService {
    int queryMoney(int userId,int homeId, String homeInDate, String homeOutDate) throws ParseException;
}
