package org.springframework.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * @author leellun
 * @date 2020/4/10 1:31
 * @desc
 */
public interface HandlerAdapter {

    boolean supports(HandlerMapping handler);

    ModelAndView handler(HttpServletRequest request, HttpServletResponse response,HandlerMapping handler) throws InvocationTargetException, IllegalAccessException;

}
