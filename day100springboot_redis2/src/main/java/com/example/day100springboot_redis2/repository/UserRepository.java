package com.example.day100springboot_redis2.repository;

import com.example.day100springboot_redis2.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
   Page<User> findByName(String name, Pageable pageable);
}
