package org.springframework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.service.DemoService;
import org.springframework.service.TeacherService;

/**
 * @author leellun
 * @date 2020/4/9 15:17
 * @desc
 */
//@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private DemoService demoService;
    @Override
    public void test() {
        demoService.test();
    }
}
