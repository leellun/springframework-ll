package org.springframework.beans.factory;

/**
 * @author leellun
 * @date 2020/4/9 18:02
 * @desc 相互依赖出现问题时抛出此异常
 */
public class UnsatisfiedDependencyException extends RuntimeException {

    public UnsatisfiedDependencyException(){

    }

    public UnsatisfiedDependencyException(String msg){
        super(msg);
    }
}
