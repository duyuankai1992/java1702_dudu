package com.sudojava.mockito.dao;

import com.sudojava.mockito.domain.Todos;

import java.util.List;

public interface TodoDao {

    boolean add(Todos todos);

    boolean delete(String id);

    List<Todos> findByTitle(String title);
}
