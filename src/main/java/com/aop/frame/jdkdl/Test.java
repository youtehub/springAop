package com.aop.frame.jdkdl;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

/**
 * 横切关注点，打印时间
 *
 * @author yyh
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("\r\n====================获取对象====================================\r\n");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop01.xml");
        HelloWorld hw1 = (HelloWorld) ctx.getBean("helloWorldImpl1");
        HelloWorld hw2 = (HelloWorld) ctx.getBean("helloWorldImpl2");

        System.out.println("\r\n====================开始执行方法====================================\r\n");

        hw1.printHelloWorld();
        System.out.println("\r\n===================方法执行完成================================\r\n");
        hw1.doPrint();

        System.out.println("\r\n===================方法执行完成================================\r\n");
        hw2.printHelloWorld();
        System.out.println("\r\n===================方法执行完成================================\r\n");
        hw2.doPrint();
    }
}
