package com.sudojava.mockito.dao;

import com.sudojava.mockito.domain.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.config.JeeNamespaceHandler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TodoDaoImp implements TodoDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean add(final Todos todos) {
        String sql = "insert into todos(title,description,version) values(?,?,?)";
        int rows_affected = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, todos.getTitle());
                preparedStatement.setString(2, todos.getDescription());
                preparedStatement.setInt(3, todos.getVersion());
            }
        });
        return rows_affected > 0 ? true : false;
    }

    /**
     * 删除操作
     *
     * @param id
     * @return
     */
    public boolean delete(final String id) {
        String sql = "delete from todos where id = ? ";
        int row_effected = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, Integer.parseInt(id));
            }
        });
        return row_effected > 0 ? true : false;
    }

    public List<Todos> findByTitle(String title) {
        String sql = "select * from todos where title = ? ";
        return jdbcTemplate.query(sql, new Object[]{title}, new RowMapper<Todos>() {
            public Todos mapRow(ResultSet resultSet, int i) throws SQLException {
                Todos todos = new Todos();
                todos.setDescription(resultSet.getString("description"));
                todos.setTitle(resultSet.getString("title"));
                todos.setVersion(resultSet.getInt("version"));
                todos.setId(resultSet.getInt("id"));
                return todos;
            }
        });
    }
}
