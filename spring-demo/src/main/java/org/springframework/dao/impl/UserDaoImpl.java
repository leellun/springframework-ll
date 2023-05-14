package org.springframework.dao.impl;

import org.springframework.dao.UserDao;
import org.springframework.entity.User;
import org.springframework.util.JdbcUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author leellun
 * date: 2020-1-2 11:21
 * desc:
 **/
public class UserDaoImpl implements UserDao {

    /**
     * @author leellun
     * date: 2020-1-2 12:29
     * desc: 查询用户
     **/
    @Override
    public User selectByName(String name) {
        String sql = "select * from t_user where user_name like " +"'%"+name+"%'";
        User user = new User();
        try {
            Statement statement = JdbcUtil.statement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("user_name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                user.setId(id);
                user.setName(name1);
                user.setEmail(email);
                user.setAge(age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

}
