package com.aop.original.javassist;


import com.aop.original.jdkdl.BusinessImpl;
import org.apache.ibatis.javassist.*;

/**
 * 自定义的类加载器
 *
 * @author yyh
 */
public class MyTranslator implements Translator {

    @Override
    public void start(ClassPool classPool) throws NotFoundException, CannotCompileException {

    }

    /**
     * 类装载到JVM前进行代码织入
     *
     * @param classPool
     * @param s
     * @throws NotFoundException
     * @throws CannotCompileException
     */
    @Override
    public void onLoad(ClassPool classPool, String classname) {
        if (!"MyTranslator.class".equals(classname)) {
            return;
        }
        //通过获取类文件
        try {
            CtClass cc = classPool.get(classname);
            CtMethod m = cc.getDeclaredMethod("doSomeThing");
            //在方法执行前插入代码
            m.insertBefore("{ System.out.println('记录日志==方法-doSomeThing()'); }");
        } catch (NotFoundException | CannotCompileException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Throwable {
        ClassPool cp = ClassPool.getDefault();
        Loader cl = new Loader();
        cl.addTranslator(cp,new MyTranslator());
//        cl.run("jsvassist.JavassistAopDemo$MyTranslator", args);
        cl.run("MyTranslator.class", args);

        BusinessImpl b = new BusinessImpl();
        b.doSomeThing2();
        b.doSomeThing();
    }
}
