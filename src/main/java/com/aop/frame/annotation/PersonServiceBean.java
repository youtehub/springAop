package com.aop.frame.annotation;


import org.springframework.stereotype.Service;

/**
 * 横切关注点，打印时间
 *
 * @author yyh
 */
@Service("userService")
public class PersonServiceBean implements PersonServer {


    @Override
    public void save(String name) {
        System.out.println("我是save()方法");
    }

    @Override
    public void update(String name, Integer id) {
        System.out.println("我是update()方法,修改id=" + id + "名字为：" + name);
    }

    @Override
    public String getPersonName(Integer id) {
        System.out.println("我是getPersonName()方法");
        return "这是个名字";
    }

    @Override
    public void delete(Integer id) {
        throw new RuntimeException();
    }

    /**
     * 获取当前页数
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Integer currentPage(Integer pageNum, Integer pageSize) {
        return (pageNum * pageSize) - (pageSize - 1);
    }
}
