package org.taru.service.six.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.six.SearchTwoDao;
import org.taru.entity.Home;
import org.taru.service.six.AdressQuaryInterface;

import java.util.List;
@Service
public class AddressImpl implements AdressQuaryInterface {
    @Autowired
    SearchTwoDao s;
    @Override
    public List<Home> addressService() {
        return s.address();
    }
}
