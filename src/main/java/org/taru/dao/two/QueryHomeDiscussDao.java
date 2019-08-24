package org.taru.dao.two;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.taru.vo.two.Home;

import java.util.List;

@Mapper
@Component
public interface QueryHomeDiscussDao {

    /**
     * 查询评论
     * @param homeId
     * @return
     */
    List<Home> queryHomeDiscuss(String homeId);

}
