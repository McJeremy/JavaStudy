package com.xuzz.study.thread;

import com.xuzz.study.core.IStudy;

/**
 * Created by xuzz on 2016/10/22.
 */
public class FirstThread extends Thread implements IStudy {
    private int i;

    @Override
    public void run()
    {
        for(;i<100;i++)
        {
            System.out.println(getName()+" "+i);
        }
    }

    public void runConsole()
    {
        for(i=0;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20)
            {
                new FirstThread().start();
                new FirstThread().start();
            }
        }
        
        new Thread(){
            @Override
            public void run()
            {
                System.out.println("welcome;"+getName());
            }
        }.start();
    }
}
