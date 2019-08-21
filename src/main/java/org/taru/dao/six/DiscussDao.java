package org.taru.dao.six;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.taru.entity.DIscussHomeVo;

import java.util.List;

/**
 * 评论的删改查
 */
@Repository
@Mapper
public interface DiscussDao {
    /**
     * 查询所有评论
     * @return
     */
    List<DIscussHomeVo> discussQuary();
    /**
     * 根据用户id查评论评论
     * @return
     */
    List<DIscussHomeVo> discussOneQuary(int id);

    /**
     * 根据id删除评论
     * @param id
     * @return
     */
    int discussDelete(int id);
}
