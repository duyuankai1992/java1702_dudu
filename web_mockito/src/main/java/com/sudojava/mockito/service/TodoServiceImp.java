package com.sudojava.mockito.service;

import com.sudojava.mockito.dao.TodoDao;
import com.sudojava.mockito.domain.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImp implements TodoService {

    @Autowired
    private TodoDao todoDao;

    public boolean add(Todos todos) {
        return todoDao.add(todos);
    }

    public boolean delete(String id) {
        return todoDao.delete(id);
    }

    public List<Todos> findByTitle(String title) {
        return  todoDao.findByTitle(title);
    }
}
