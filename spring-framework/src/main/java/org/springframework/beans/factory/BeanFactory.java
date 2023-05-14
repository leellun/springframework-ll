package org.springframework.beans.factory;

/**
 * @author leellun
 * @date 2020/4/8 11:39
 * @desc 单例工厂的顶层设计
 */
public interface BeanFactory {

    /**
     * 根据beanName从IOC容器中获得一个实例bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName);

    Object getBean(Class<?> beanClass);
}
