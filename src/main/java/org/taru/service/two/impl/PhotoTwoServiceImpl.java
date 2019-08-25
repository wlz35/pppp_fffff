package org.taru.service.two.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.two.PhotoTwoDao;
import org.taru.service.two.PhotoTwoService;
import org.taru.vo.two.Pictures;

@Service
public class PhotoTwoServiceImpl implements PhotoTwoService {
    @Autowired
    PhotoTwoDao photoTwoDao;

    @Override
    public int photoUpload1(Pictures pictures) {
        return photoTwoDao.photoTwoUpload(pictures);
    }
}
