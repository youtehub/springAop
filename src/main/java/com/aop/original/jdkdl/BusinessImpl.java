package com.aop.original.jdkdl;

interface IBusiness{
    /**
     * 完成功能
     */
    void doSomeThing();
}

interface IBusiness2{
    /**
     * 完成功能2
     */
    void doSomeThing2();
}

/**
 * @author yyh
 * 业务实现类
 */
public class BusinessImpl implements IBusiness, IBusiness2 {

    @Override
    public void doSomeThing() {
        System.out.println("执行业务逻辑");
    }

    @Override
    public void doSomeThing2() {
        System.out.println("执行业务逻辑2");
    }
}
