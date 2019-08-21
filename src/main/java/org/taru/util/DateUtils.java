package org.taru.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理工具类
 */
public class DateUtils {

    private static SimpleDateFormat  simpleDateFormat =new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat  simpleDateFormat2 =new  SimpleDateFormat("yyyy-MM-dd");
    public static  String toString(Date date){
        if(date!=null){
          return  simpleDateFormat.format(date);
        }
        return null;
    }

    /**
     * 只要年月日
     * @param date
     * @return
     */
    public static String toDayStriing(Date date){
        if(date!=null){
            return  simpleDateFormat2.format(date);
        }
        return null;
    }
}
