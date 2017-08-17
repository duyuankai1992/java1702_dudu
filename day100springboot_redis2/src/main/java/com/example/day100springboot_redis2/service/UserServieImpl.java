package com.example.day100springboot_redis2.service;

import com.example.day100springboot_redis2.domain.User;
import com.example.day100springboot_redis2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServieImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<User> findByName(String name, Pageable pageable) {
        return repository.findByName(name,pageable);
    }
}
