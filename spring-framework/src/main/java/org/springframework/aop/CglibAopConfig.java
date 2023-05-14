package org.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.AdviceSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.ReflectiveMethodInvocation;

/**
 * @author leellun
 * @date 2020/4/11 20:47
 * @desc 使用CGLib实现动态代理，完全不受代理类必须实现接口的限制，
 *        而且CGLib底层采用ASM字节码生成框架，使用字节码技术生成代理类，比使用Java反射效率要高。
 *        唯一需要注意的是，CGLib不能对声明为final的方法进行代理，因为CGLib原理是动态生成被代理类的子类。
 */
public class CglibAopConfig implements AopProxy, MethodInterceptor {

    public CglibAopConfig(AdviceSupport adviceSupport) {

    }
    @Override
    public Object getProxy() {
        return null;
    }
    @Override
    public Object getProxy(ClassLoader classLoader) {
        return null;
    }
    @Override
    public Object invoke(ReflectiveMethodInvocation methodInvocation) {
        return null;
    }
}
