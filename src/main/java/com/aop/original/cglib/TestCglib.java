package com.aop.original.cglib;


/**
 * 测试cglib字节码代理
 *
 * @author Yiuahm
 */
public class TestCglib {
    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeImpl bookFacade = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());
        bookFacade.addBook();
        bookFacade.deleteBook();
    }
}
