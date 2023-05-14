package org.springframework.aop.framework.adapter;


import org.aopalliance.intercept.MethodInterceptor;
import org.aspectj.lang.JoinPoint;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.aspectj.AbstractAspectJAdvice;
import org.springframework.aop.framework.ReflectiveMethodInvocation;

import java.lang.reflect.Method;

/**
 * @author leellun
 * @date 2020/4/11 23:17
 * @desc 处理前置通知
 */
public class MethodBeforeAdviceInterceptor extends AbstractAspectJAdvice implements MethodInterceptor, BeforeAdvice {

    private JoinPoint joinPoint;

    public MethodBeforeAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }
    @Override
    public Object invoke(ReflectiveMethodInvocation mi) throws Throwable{
        this.joinPoint = mi;
        before(mi.getMethod(),mi.getArguments(),mi.getThis());
        return mi.proceed();
    }

    private void before(Method method,Object[] arguments,Object target) throws Throwable{
        super.invokeAdviceMethod(this.joinPoint,null,null);
    }
}
