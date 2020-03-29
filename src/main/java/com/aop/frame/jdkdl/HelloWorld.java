package com.aop.frame.jdkdl;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk代理业务类
 *
 * @author yyh
 */
public interface HelloWorld {

    /**
     * 打印 HelloWorld
     */
    void printHelloWorld();

    /**
     * 执行打印操作
     */
    void doPrint();
}
