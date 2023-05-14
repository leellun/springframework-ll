package org.aopalliance.intercept;

import org.aspectj.lang.JoinPoint;

/**
 * @author leellun
 * @date 2020/4/11 15:31
 * @desc 这个接口表示程序中的调用。调用是一个连接点，可以被一个拦截器执行。
 */
public interface Invocation extends JoinPoint {

    /**
     *将参数作为数组对象获取。
     * @return 调用的参数
     */
    Object[] getArguments();
}
