package org.taru.dao.six;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.taru.entity.UserRelationVo;

import java.util.List;


@Repository
@Mapper
public interface ShareSixDao {
    /**
     * 根据当前用户id查好友id
     */
    List<UserRelationVo>  shareoneSixDao(int id);

    /**
     * 根据好友ID，房源ID
     * @param relationId
     * @param homeId
     * @return
     */
    int shareDao(int relationId,int homeId);
}
