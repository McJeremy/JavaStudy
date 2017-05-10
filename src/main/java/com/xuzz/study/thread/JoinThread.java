package com.xuzz.study.thread;

import com.xuzz.study.core.IStudy;

/**
 * Created by xuzz on 2016/10/22.
 */
public class JoinThread extends Thread implements IStudy {

    public JoinThread(){}
    public JoinThread(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        for(int i=0;i<100;i++)
        {
            System.out.println(getName()+" "+i);
        }
    }

    public void runConsole()
    {
        try {
            new JoinThread("新线程").start();
            for (int i = 0; i < 100; i++) {
                if (i == 20) {
                    JoinThread jt = new JoinThread("Join的县城");
                    jt.start();
                    jt.join(); //在这个地方，是Main线程调用的join,因此,Main线程就会等待jt线程执行完成。
                }
            }
            System.out.println(Thread.currentThread().getName());
        }catch (Exception e){}
    }
}
