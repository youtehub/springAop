package com.aop.frame.unconfigure;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 被代理的目标类
 *
 * @author yyh
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationCfg.class);
        Math math = context.getBean("math", Math.class);
        int n1 = 100, n2 = 0;
        math.add(n1,n2);
        math.sub(n1,n2);
        math.mut(n1,n2);
        try {
            math.div(n1,n2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = context.getBean("getUser", User.class);
        user.show();
    }
}
