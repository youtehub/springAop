package com.aop.frame.annotation;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring AOP测试
 *
 * @author yyh
 */
public class Tester {

    private final static Log log = LogFactory.getLog(Tester.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop02.xml");
        PersonServiceBean userService = (PersonServiceBean) context.getBean("userService");
        String personName = userService.getPersonName(1);
        userService.save(personName);
        userService.currentPage(12,10);
        try {
            userService.delete(1);
        } catch (Exception e) {
            if (log.isWarnEnabled()) {
                log.warn("Delete user : " + e.getMessage());
            }
        }
    }

}
