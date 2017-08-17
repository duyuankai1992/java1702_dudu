package com.sudojava.mockito.service;

import com.sudojava.mockito.dao.UserDao;
import com.sudojava.mockito.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean login(User user) {
        return userDao.login(user);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }
}
