package org.springframework.aop.aspectj;

import org.aopalliance.intercept.MethodInterceptor;
import org.aspectj.lang.JoinPoint;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.framework.ReflectiveMethodInvocation;

import java.lang.reflect.Method;

/**
 * @author leellun
 * @date 2020/4/11 23:32
 * @desc 处理最终返回通知
 */
public class AspectJAfterAdvice extends AbstractAspectJAdvice implements MethodInterceptor, AfterAdvice {

    private JoinPoint joinPoint;

    public AspectJAfterAdvice(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    public Object invoke(ReflectiveMethodInvocation mi)throws Throwable{
        try {
            this.after(null,mi.getMethod(),mi.getArguments(),mi.getThis());
            return mi.proceed();
        }finally {
            this.joinPoint = mi;
        }
    }

    private void after(Object returnValue, Method method, Object[] arguments, Object aThis) throws Throwable {
        super.invokeAdviceMethod(joinPoint,returnValue,null);
    }
}
