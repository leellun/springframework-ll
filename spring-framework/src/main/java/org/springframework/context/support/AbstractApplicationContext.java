package org.springframework.context.support;

/**
 * @author leellun
 * @date 2020/4/8 11:56
 * @desc IOC容器实现的顶层设计
 */
public abstract class AbstractApplicationContext {
    //受保护，只提供给子类重写
    public void refresh() throws Exception {}
}
