package org.taru.dao.three;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface AddHomeDao {
    int addhome(String styleName,String homeName,String homeAddress
            ,String homePrice,String home_in_Date,String home_out_Date,String picturesId,String homeDescribe,String homeSpot,String homeConfigure,
                String landlordPhone);
}
