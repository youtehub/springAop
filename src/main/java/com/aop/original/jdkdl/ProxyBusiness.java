package com.aop.original.jdkdl;

import java.lang.reflect.Method;

public class ProxyBusiness implements IBusiness, IBusiness2 {

    private LogInvocationHandler h;

    @Override
    public void doSomeThing2() {
        try {
            Method m = (h.getTarget()).getClass().getMethod("doSomeThing", null);
            h.invoke(this, m, null);
        } catch (Throwable e) {
            // 异常处理（略）
        }
    }

    @Override
//    public boolean doSomeThing() {
    public void doSomeThing() {
        try {
            Method m = (h.getTarget()).getClass().getMethod("doSomeThing2", null);
//            return (Boolean) h.invoke(this, m, null);
            h.invoke(this, m, null);

        } catch (Throwable e) {
            // 异常处理（略）
        }
//        return false;
    }

    public ProxyBusiness(LogInvocationHandler h) {
        this.h = h;
    }

    //测试用
    public static void main(String[] args) {
        //构建AOP的Advice
        LogInvocationHandler handler = new LogInvocationHandler(new BusinessImpl());
        new ProxyBusiness(handler).doSomeThing();
        new ProxyBusiness(handler).doSomeThing2();
    }
}