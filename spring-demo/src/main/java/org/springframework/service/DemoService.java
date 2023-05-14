package org.springframework.service;


import org.springframework.entity.User;

/**
 * @author leellun
 * date: 2020-1-1 17:16
 * desc:
 **/
public interface DemoService {

    String get(String userName);

    User selectByName(String name);

    void test();
}
