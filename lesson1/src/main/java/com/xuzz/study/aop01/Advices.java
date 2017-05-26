package com.xuzz.study.aop01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Created by xuzz on 2017/2/16.
 */
public class Advices {

    public void before(JoinPoint jp)
    {
        System.out.println("----------前置通知----------");
        System.out.println(jp.getSignature().getName());
        Object ob = jp.getTarget();
        String method = jp.getSignature().getName();
        Class<?>[] interfaces = ob.getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature)jp.getSignature()).getMethod().getParameterTypes();
    }
    public void after(JoinPoint jp)
    {
        System.out.println("----------最终通知----------");
    }
}
