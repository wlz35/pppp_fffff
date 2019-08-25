package org.taru.dao.two;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.taru.vo.two.Pictures;

@Mapper
@Component("PhotoMapper")
public interface PhotoTwoDao {
    int photoTwoUpload(Pictures pictures);
}
