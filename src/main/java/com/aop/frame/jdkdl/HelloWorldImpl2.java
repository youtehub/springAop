package com.aop.frame.jdkdl;


/**
 * jdk代理业务类
 *
 * @author yyh
 */
public class HelloWorldImpl2 implements HelloWorld {

    @Override
    public void printHelloWorld() {
        System.out.println("Enter HelloWorldImpl2.printHelloWorld()");
    }

    @Override
    public void doPrint() {
        System.out.println("Enter HelloWorldImpl2.doPrint()");
        return;
    }
}
