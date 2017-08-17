package com.sudojava.spring.dao;

import com.sudojava.spring.domain.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class TodoDaoImp implements TodoDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean addUser(final  Todos todos) {
        int row_effect = jdbcTemplate.update("insert into todos(description,title,version) values(?,?,?)", new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,todos.getDescription());
                preparedStatement.setString(2,todos.getTitle());
                preparedStatement.setInt(3,todos.getVersion());
            }
        });
        return row_effect > 0 ? true : false;
    }
}
