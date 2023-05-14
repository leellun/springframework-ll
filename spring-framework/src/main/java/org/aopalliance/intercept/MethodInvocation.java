package org.aopalliance.intercept;

import java.lang.reflect.Method;

/**
 * @author leellun
 * @date 2020/4/11 15:33
 * @desc 对方法的调用的描述
 */
public interface MethodInvocation extends Invocation{

    /**
     * 获取被调用的方法。
     * @return
     */
    Method getMethod();
}
