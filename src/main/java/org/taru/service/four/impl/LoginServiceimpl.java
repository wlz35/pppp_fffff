package org.taru.service.four.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taru.dao.four.LoginDao;
import org.taru.entity.Admin;
import org.taru.service.four.LoginService;


@Service
public class LoginServiceimpl implements LoginService {
    @Autowired
    LoginDao ld;
    public Admin loginservice(String name, String password){

        return ld.login(name,password);
    }
}
