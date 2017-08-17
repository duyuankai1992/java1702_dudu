package com.sudojava.mockito.dao;

import com.sudojava.mockito.domain.User;

public interface UserDao {

    public boolean login(User user);

    public boolean addUser(User user);

}
