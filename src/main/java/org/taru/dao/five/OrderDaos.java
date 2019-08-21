package org.taru.dao.five;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDaos {
    int selectPriceById(int homeId);
}
