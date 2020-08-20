package com.example.myecsite.repository;

import com.example.myecsite.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<User> USER_ROW_MAPPER = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setAddress(rs.getString("address"));
        user.setZipcode(rs.getString("zipcode"));
        user.setTelephone(rs.getString("telephone"));
        return user;
    };

    public void save(User user) {
        String insertSql = "INSERT INTO users(name, email, password, address, zipcode, telephone) VALUES(:name, :email, :password, :address, :zipcode, :telephone)";
        SqlParameterSource param = new BeanPropertySqlParameterSource(user);
        template.update(insertSql, param);
    }

    /**
     *
     * @param email
     * @return ユーザーが存在する場合はUser、存在しない場合はnullを返す
     */
    public User findByEmail(String email) {
        String sql = "SELECT id, name, email, password, address, zipcode, telephone FROM users WHERE email = :email";
        SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
        List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
        if(userList.isEmpty()){
            return null;
        }
        return userList.get(0);
    }
}
