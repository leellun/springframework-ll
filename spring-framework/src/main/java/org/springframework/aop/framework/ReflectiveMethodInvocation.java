package org.springframework.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.ProxyMethodInvocation;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author leellun
 * @date 2020/4/11 14:50
 * @desc
 */
public class ReflectiveMethodInvocation implements ProxyMethodInvocation {

    private Object proxy;
    private Object target;
    private Method method;
    private Object[] arguments;
    private Class<?> targetClass;
    private List<Object> interceptorsAndDynamicMethodMatchers;

    /**
     * 当前interceptor的索引
     */
    private int currentInterceptorIndex = -1;

    public ReflectiveMethodInvocation(
            Object proxy, Object target, Method method, Object[] arguments,
            Class<?> targetClass, List<Object> interceptorsAndDynamicMethodMatchers) {

        this.proxy = proxy;
        this.target = target;
        this.targetClass = targetClass;
        this.method = method;
        this.arguments = arguments;
        this.interceptorsAndDynamicMethodMatchers = interceptorsAndDynamicMethodMatchers;
    }

    /**
     * 执行拦截器调用链的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object proceed() throws Throwable {
        // We start with an index of -1 and increment early.
        //判断当前拦截器的索引等于执行器链的size（）-1，就执行他自己（这种情况只能是没有拦截器或者是最后一个拦截器了）
        if (this.currentInterceptorIndex == this.interceptorsAndDynamicMethodMatchers.size() - 1) {
            return method.invoke(this.target,this.arguments);
        }

        Object interceptorOrInterceptionAdvice =
                this.interceptorsAndDynamicMethodMatchers.get(++this.currentInterceptorIndex);
        if (interceptorOrInterceptionAdvice instanceof MethodInterceptor) {
            MethodInterceptor mi =
                    (MethodInterceptor) interceptorOrInterceptionAdvice;
            return mi.invoke(this);
        }else {
            //动态匹配失败时，跳过当前Interceptor,调用下一个拦截器
            return proceed();
        }
    }
    @Override
    public Method getMethod() {
        return this.method;
    }
    @Override
    public Object[] getArguments() {
        return this.arguments;
    }

    @Override
    public Object getProxy() {
        return this.proxy;
    }
    @Override
    public Object getThis() {
        return this.target;
    }
}
