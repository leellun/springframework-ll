package org.springframework.aop;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author leellun
 * @date 2020/4/11 15:37
 * @desc AOP的扩展MethodInvocation接口，允许访问方法调用通过的代理。
 */
public interface ProxyMethodInvocation extends MethodInvocation {

    /**
     * 返回此方法通过调用的代理。
     * @return
     */
    Object getProxy();
}