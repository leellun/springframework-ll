package org.springframework.dao;


import org.springframework.entity.User;

/**
 * @author leellun
 * date: 2020-1-2 10:42
 * desc:
 **/
public interface UserDao {

    User selectByName(String name);
}
