package com.aop.original.jdkdl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 业务代理实现类
 *
 * @author yyh
 */
public class LogInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行织入的日志，你可以控制那些方法执行切入逻辑
        if (method.getName().equals("doSomeThing2")) {
            System.out.println("执行业务逻辑2--记录日志");
        }
        method.invoke(target, args);
        return null;
    }
}
