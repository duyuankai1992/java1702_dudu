package com.example.day100springboot_redis2.service;

import com.example.day100springboot_redis2.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User addUser(User user);
    Iterable<User> findAll();

    Page<User> findByName(String name, Pageable pageable);
}
