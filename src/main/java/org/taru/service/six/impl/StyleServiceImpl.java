package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.SearchTwoDao;
import org.taru.entity.Style;
import org.taru.service.six.StyleServiceInterface;

import java.util.List;

@Service
public class StyleServiceImpl implements StyleServiceInterface {
    @Autowired
    SearchTwoDao s;

    @Override
    public List<Style> stylesDao() {
        return s.styleDao();
    }
}
