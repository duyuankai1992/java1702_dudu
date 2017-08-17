package com.sudojava.mockito.service;

import com.sudojava.mockito.domain.Todos;

import java.util.List;

public interface TodoService {

    boolean add(Todos todos);

    boolean delete(String id);

    List<Todos> findByTitle(String title);

}
