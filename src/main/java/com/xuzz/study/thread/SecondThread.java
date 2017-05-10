package com.xuzz.study.thread;

import com.xuzz.study.core.IStudy;

/**
 * Created by xuzz on 2016/10/22.
 */
public class SecondThread implements Runnable, IStudy {
    private int i;
    public void run()
    {
        for(;i<100;i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public void runConsole()
    {
        for(int i=0;i<100;i++)
        {
            if(i==20)
            {
                SecondThread st = new SecondThread();
                new Thread(st,"新县城1").start();
                new Thread(st,"新县城2").start();
            }
        }
    }
}
