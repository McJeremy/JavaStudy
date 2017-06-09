package com.xuzz.study.classloader;

import java.util.List;

/**
 * Created by win10 on 2017/6/5.
 */
public class BasicClassLoaderTest {
    @SuppressWarnings("rawtypes")
    public static void run()
    {
        System.out.println("BasicClassLoaderTest的类加载器是："+BasicClassLoaderTest.class.getClassLoader().getClass().getName());
        System.out.println("BasicClassLoaderTest默认的类加载器:"+BasicClassLoaderTest.class.getClassLoader().getSystemClassLoader());
        System.out.println("System的类加载器是："+System.class.getClassLoader());
        System.out.println("List的类加载器是："+List.class.getClassLoader());



        ClassLoader classLoader=BasicClassLoaderTest.class.getClassLoader();
        while(null!=classLoader)
        {
            System.out.print(classLoader.getClass().getName()+"->");
            classLoader=classLoader.getParent();
        }
        System.out.print(classLoader);
    }
}
