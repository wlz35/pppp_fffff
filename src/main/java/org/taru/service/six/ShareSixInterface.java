package org.taru.service.six;

import org.taru.entity.UserRelationVo;

import java.util.List;

public interface ShareSixInterface {
    List<UserRelationVo> shareSixDao(int id);
}
