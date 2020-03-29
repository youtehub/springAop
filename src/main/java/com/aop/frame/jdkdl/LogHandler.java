package com.aop.frame.jdkdl;

import org.aspectj.lang.annotation.Pointcut;

import java.time.LocalDateTime;

/**
 * 横切关注点，打印日志
 *
 * @author yyh
 */
public class LogHandler {
    public void logBefore(){
        System.out.println("开始执行doPrint()方法");

    }
    public void logAfter(){
        System.out.println("结束执行doPrint()方法");

    }
}
