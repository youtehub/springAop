package com.aop.frame.annotation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 横切关注点，打印时间
 *
 * @author yyh
 */
public interface PersonServer {

    /**
     * 保存用户名
     *
     * @param name
     */
    void save(String name);

    /**
     * 更新
     *
     * @param name
     * @param id
     */
    void update(String name, Integer id);

    /**
     * 根据编号获取用户名
     *
     * @param id
     * @return
     */
    String getPersonName(Integer id);

    /**
     * 删除用户
     * @param id
     */
    void  delete(Integer id);


}
