package com.aop.frame.unconfigure;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 应用配置文件
 *
 * @author yyh
 */
//用于表示当前类为容器的配置类，类似<beans/>
@Configuration
//扫描的范围，相当于xml配置的结点<context:component-scan/>
@ComponentScan(basePackages = "com.aop.frame.unconfigure")
////自动代理，相当于<aop:aspectj-autoproxy
// proxy-target-class="true"></aop:aspectj-autoproxy>
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ApplicationCfg {
    //在配置中声明一个bean，相当于<bean id=getUser
    // class="com.zhangguo.Spring052.aop05.User"/>
    @Bean(name = "math")
    public Math getMath() {
        return new Math();
    }

    @Bean
    public User getUser() {
        return new User();
    }


}
