package com.aop.frame.unconfigure;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 通知类，横切逻辑
 *
 * @author yyh
 */
@Component
@Aspect
public class Advices {
    /**
     * 切点
     */
    @Pointcut("execution(* com.aop.frame.unconfigure.Math.a*(..))")
    public void pointcut() {

    }

    /**
     * 前置通知
     *
     * @param joinPoint
     */
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知，准备执行方法--" + joinPoint.getSignature().getName());
    }

    /**
     * 最终通知
     *
     * @param joinPoint
     */
    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("最终通知，完成方法执行--" + joinPoint.getSignature().getName());
    }

    /**
     * 环绕通知
     *
     * @param pjp
     */
    @Around("execution(* com.aop.frame.unconfigure.Math.s*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("方法执行--" + pjp.getSignature().getName());
        System.out.println("----------环绕前置----------");
        Object result = pjp.proceed();
        System.out.println("----------环绕后置----------");
        return result;
    }

    /**
     * 异常后通知
     *
     * @param joinPoint
     * @param exp
     */
    @AfterThrowing(value = "execution(* com.aop.frame.unconfigure.Math.d*(..))",
            throwing = "exp")
    public void afterThrowing(JoinPoint joinPoint, Exception exp) {
        System.out.println("方法执行--" + joinPoint.getSignature().getName());
        System.out.println("异常消息：" + exp.getMessage());
        System.out.println("----------异常通知----------");
    }

}
