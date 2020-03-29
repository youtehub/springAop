package com.aop.frame.annotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 记录切面
 *
 * @author yyh
 */
//指定切面的优先级，当有多个切面时，数值越小优先级越高
//@Order(1)
//把这个类声明为一个切面：需要把该类放入到IOC容器中。再声明为一个切面.
@Aspect
@Component
public class LoggingAspect {

    /**
     * 声明切入点表达式，一般在该方法中不再添加其他代码。
     * 使用@Pointcut来声明切入点表达式。
     * 后面的通知直接使用方法名来引用当前的切入点表达式。
     */
    @Pointcut("execution(* com.aop.frame.annotation.PersonServiceBean.*(..))")
//    @Pointcut("execution(* com.aop.frame.jdkdl.HelloWorld.*(..))")
    public void declareJoinPointExpression() {
    }

    /**
     * 前置通知，在目标方法开始之前执行。
     *
     * @param joinPoint
     * @Before("execution(public int PersonServiceBean.add(int, int))")
     * 这样写可以指定特定的方法。
     */
    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        //这里使用切入点表达式即可。后面的可以都改成切入点表达式。
        // 如果这个切入点表达式在别的包中，在前面加上包名和类名即可。
        String name = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("前置通知：The method " + name + " begins with " + args);

    }

    /**
     * 后置通知，在目标方法执行之后开始执行，无论目标方法是否抛出异常。
     * 在后置通知中不能访问目标方法执行的结果。
     *
     * @param joinPoint
     */
    @After("execution(* com.aop.frame.annotation.PersonServiceBean.*(Integer ,Integer ))")
    public void afterMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        //List<Object>args = Arrays.asList(joinpoint.getArgs());
        Object target = joinPoint.getTarget();
        // 后置通知方法中可以获取到参数
        System.out.println("后置通知：The method " + name + " ends "+target);
    }

    /**
     * 返回通知，在方法正常结束之后执行。
     * 可以访问到方法的返回值。
     *
     * @param joinPoint
     * @param result    目标方法的返回值
     */
    @AfterReturning(value = "execution(* com.aop.frame.annotation." +
            "PersonServiceBean.*(..))",
            returning = "result")
    public void afterReturnning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println("返回通知：The method "
                + name + " end with " + result);
    }

    /**
     *异常通知。目标方法出现异常的时候执行，可以访问到异常对象，可以指定在出现特定异常时才执行。
     *假如把参数写成NullPointerException则只在出现空指针异常的时候执行。
     * @param joinpoint
     * @param e
     */
    @AfterThrowing(value="execution(* com.aop.frame.annotation.PersonServiceBean.*(..))", throwing="e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        String name = joinPoint.getSignature().getName();
        System.out.println("异常通知：The method "+ name +" occurs exception " + e);
    }

    /**
     * 环绕通知类似于动态代理的全过程，ProceedingJoinPoint类型的参数可以决定是否执行目标方法。
     * @param point 环绕通知需要携带ProceedingJoinPoint类型的参数。
     * @return 目标方法的返回值。必须有返回值。
     */
     /*不常用
    @Around("execution(public int com.aop.frame.annotation.service.PersonServiceBean.*(..))")
    public Object aroundMethod(ProceedingJoinPoint point) {
        Object result = null;
        String methodName = point.getSignature().getName();
        try {
            //前置通知
            System.out.println("The method "+ methodName +" begins with " + Arrays.asList(point.getArgs()));
            //执行目标方法
            result = point.proceed();
            //翻译通知
            System.out.println("The method "+ methodName +" ends with " + result);
        } catch (Throwable e) {
            //异常通知
            System.out.println("The method "+ methodName +" occurs exception " + e);
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("The method "+ methodName +" ends");
        return result;
    }
    */
}
