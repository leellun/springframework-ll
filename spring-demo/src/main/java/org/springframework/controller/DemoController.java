package org.springframework.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.entity.User;
import org.springframework.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.annotation.RequestMapping;
import org.springframework.web.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author leellun
 * date: 2020-1-1 17:17
 * desc:
 **/
@Controller
@RequestMapping("/demo/")
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     * @author leellun
     * date: 2020-1-1 22:33
     * desc: 测试，把数据响应到浏览器
     **/
    @RequestMapping("/user")
    public void test(HttpServletRequest request,HttpServletResponse response,
                     @RequestParam("userName") String userName,
                     @RequestParam("age") Integer age,
                     @RequestParam("sex") Double sex){
        try {
            String result = "<h1 align='center'>My name is " + userName +",age:"+age+ ",sex" + sex + "</h1>";
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/main")
    public ModelAndView main(@RequestParam("userName") String userName, @RequestParam("age") String age){
        User user = demoService.selectByName(userName);
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("userName", userName);
        model.put("age",age);
        model.put("data", user);
        model.put("token", "123456789");
        return new ModelAndView("main.html",model);
    }

}
