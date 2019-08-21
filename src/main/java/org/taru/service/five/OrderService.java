package org.taru.service.five;

import java.text.ParseException;
import java.util.Date;

public interface OrderService {
    int queryMoney(int homeId, String homeInDate, String homeOutDate) throws ParseException;
}
