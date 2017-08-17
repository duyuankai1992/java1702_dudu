package com.sudojava.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoJdbcApplicationTests {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Test
	public void addUser() {
		User user = new User();
		user.setPassword("asdf");
		user.setUsername("ddd");
		int row_effect = jdbcTemplate.update("insert into user(username,password) values(?,?)", new PreparedStatementSetter() {
			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1,user.getUsername());
				preparedStatement.setString(2,user.getPassword());
			}
		});
		System.out.println("---->>"+row_effect);
		//return row_effect > 0 ? true : false;
	}

}
