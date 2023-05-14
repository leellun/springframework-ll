package org.springframework.aop.framework.adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aspectj.lang.JoinPoint;
import org.springframework.aop.aspectj.AbstractAspectJAdvice;
import org.springframework.aop.framework.ReflectiveMethodInvocation;

import java.lang.reflect.Method;

/**
 * @author leellun
 * @date 2020/4/12 19:16
 * @desc 正常返回通知，如果有异常则不会执行
 */
public class AfterReturningAdviceInterceptor extends AbstractAspectJAdvice implements MethodInterceptor {

    private JoinPoint joinPoint;

    public AfterReturningAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }
    @Override
    public Object invoke(ReflectiveMethodInvocation mi) throws Throwable {

        Object returnValue = mi.proceed();
        this.joinPoint = mi;
        this.afterReturning(returnValue,mi.getMethod(),mi.getArguments(),mi.getThis());
        return returnValue;
    }

    private void afterReturning(Object returnValue, Method method, Object[] arguments, Object aThis) throws Throwable {
        super.invokeAdviceMethod(joinPoint,returnValue,null);
    }
}
