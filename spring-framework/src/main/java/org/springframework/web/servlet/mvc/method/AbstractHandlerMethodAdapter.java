package org.springframework.web.servlet.mvc.method;


import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * @author leellun
 * @date 2020/4/10 12:54
 * @desc
 */
public abstract class AbstractHandlerMethodAdapter implements HandlerAdapter {

    @Override
    public boolean supports(HandlerMapping handler) {
        return (handler instanceof HandlerMapping);
    }
    @Override
    public ModelAndView handler(HttpServletRequest request, HttpServletResponse response, HandlerMapping handler) throws InvocationTargetException, IllegalAccessException {
        return handleInternal(request, response, handler);
    }

    protected abstract ModelAndView handleInternal(HttpServletRequest request, HttpServletResponse response, HandlerMapping handler) throws InvocationTargetException, IllegalAccessException;
}
