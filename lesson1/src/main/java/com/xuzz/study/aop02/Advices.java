package com.xuzz.study.aop02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by xuzz on 2017/2/16.
 */
@Component
@Aspect
public class Advices {

    /*
    * 相当于在xml中配置：
    <!-- 通知 -->
    <bean id="advices" class="com.zhangguo.Spring052.aop01.Advices"></bean>

    <!-- aop配置 -->
    <aop:config proxy-target-class="true">
        <!--切面 -->
        <aop:aspect ref="advices">
            <!-- 切点 -->
            <aop:pointcut expression="execution(* com.zhangguo.Spring052.aop01.Math.*(..))" id="pointcut1"/>
            <!--连接通知方法与切点 -->
            <aop:before method="before" pointcut-ref="pointcut1"/>
            <aop:after method="after" pointcut-ref="pointcut1"/>
        </aop:aspect>
    </aop:config>
    *
    * */
    @Before("execution(* com.xuzz.study.aop02.AopMath.*(**))")
    public void before(JoinPoint jp)
    {
        System.out.println("----------前置通知----------");
        System.out.println(jp.getSignature().getName());
    }
    @After("execution(* com.xuzz.study.aop02.AopMath.*(**))")
    public void after(JoinPoint jp)
    {
        System.out.println("----------最终通知----------");
    }
}
