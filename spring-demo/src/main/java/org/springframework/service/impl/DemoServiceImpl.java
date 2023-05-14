package org.springframework.service.impl;


import org.springframework.context.annotation.Lazy;
import org.springframework.dao.UserDao;
import org.springframework.dao.impl.UserDaoImpl;
import org.springframework.entity.User;
import org.springframework.service.DemoService;
import org.springframework.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * @author leellun
 * date: 2020-1-1 17:16
 * desc:
 **/
@Service
@Lazy //是否懒加载，默认值为true
public class DemoServiceImpl implements DemoService {

//    @Autowired
    private TeacherService teacherService;

    @Override
    public String get(String userName) {
       int i = 1/0;
       return "my name is " + userName;
    }

    @Override
    public User selectByName(String name) {
//        int i = 1/0;
        UserDao userDao = new UserDaoImpl();
        User user = userDao.selectByName(name);
        return user;
    }

    @Override
    public void test() {
        teacherService.test();
        System.out.println("chengogn");
    }
}


