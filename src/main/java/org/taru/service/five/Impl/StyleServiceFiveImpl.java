package org.taru.service.five.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.five.StyleDaos;
import org.taru.entity.Style;
import org.taru.service.five.StyleService;

import java.util.List;

@Service
public class StyleServiceFiveImpl implements StyleService {


    @Autowired
    StyleDaos impl;
    //查询风格（style）的说有信息
    public List queryStyleService(){
       List list = impl.queryStyleDao();
       return list;
    }

    //添加风格（style）
    public int addStyleService(Style style){
       int row = impl.addStyleDao(style);
       return row;
    }

    //根据ID修改风格
    public int updateStyleService(Style style){
      int row = impl.updateStyleDao(style);
      return row;
    }
    //根据ID逻辑删除
    public int deleteStyleService(int styleId){
       int row = impl.deleteStyleDao(styleId);
       return row;
    }
}
