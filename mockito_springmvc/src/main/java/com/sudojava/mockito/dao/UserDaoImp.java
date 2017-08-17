package com.sudojava.mockito.dao;

import com.sudojava.mockito.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserDaoImp implements UserDao{

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean login(User user) {
        String sql = "select * from user where username = ? and password = ?";
        Object[] params = new Object[]{user.getUsername(), user.getPassword()};
        User result = jdbcTemplate.queryForObject(sql, params, User.class);
        System.out.println("result---->>" + result);
        return result != null ? true : false;
    }

    @Override
    public boolean addUser(User user) {
        int row_effect = jdbcTemplate.update("insert into user(username,password) values(?,?)", new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1,user.getUsername());
                preparedStatement.setString(2,user.getPassword());
            }
        });
        return row_effect > 0 ? true : false;
    }
}
