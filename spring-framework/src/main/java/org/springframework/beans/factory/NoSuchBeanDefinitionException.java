package org.springframework.beans.factory;

/**
 * @author leellun
 * @date 2020/4/9 13:36
 * @desc 从容器中找不到bean的时候抛出此异常
 */
public class NoSuchBeanDefinitionException extends RuntimeException{

    public NoSuchBeanDefinitionException() {

    }

    public NoSuchBeanDefinitionException(String msg) {
        super(msg);
    }
}
