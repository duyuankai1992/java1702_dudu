package com.sudojava.mockito.service;

import com.sudojava.mockito.domain.User;

public interface UserService {

    public boolean login(User user);

    public boolean addUser(User user);


}
