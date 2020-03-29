package com.aop.frame.jdkdl;


import java.time.LocalDateTime;

/**
 * 横切关注点，打印时间
 *
 * @author yyh
 */
public class TimeHandler{

    public void printTime(){
        System.out.println("CurrentTime = "+ LocalDateTime.now());

    }
}
