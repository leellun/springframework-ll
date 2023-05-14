package org.aopalliance.intercept;


import org.springframework.aop.framework.ReflectiveMethodInvocation;

/**
 * @author leellun
 * @date 2020/4/11 15:26
 * @desc
 */
public interface MethodInterceptor {

    Object invoke(ReflectiveMethodInvocation methodInvocation) throws Throwable;
}
