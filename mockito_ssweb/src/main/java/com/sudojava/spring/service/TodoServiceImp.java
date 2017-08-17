package com.sudojava.spring.service;

import com.sudojava.spring.dao.TodoDao;
import com.sudojava.spring.domain.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImp implements TodoService {

    @Autowired
    TodoDao todoDao;
    public boolean addUser(Todos todos) {
        return todoDao.addUser(todos);
    }
}
