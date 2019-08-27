package org.taru.dao.three;

import org.apache.ibatis.annotations.Mapper;
import org.taru.entity.AddHome;
import org.taru.entity.Pictures;


@Mapper
public interface AddHomeDao {
    int addPicture(Pictures pictures);
    int addhome(AddHome addHome);
}
