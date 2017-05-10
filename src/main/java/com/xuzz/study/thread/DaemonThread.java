package com.xuzz.study.thread;

import com.xuzz.study.core.IStudy;

/**
 * 后台线程
 * Created by xuzz on 2016/10/22.
 */

public class DaemonThread  extends Thread implements IStudy{

    public void run()
    {
        for(int i=0;i<1000;i++)
        {
            System.out.println(getName()+" "+i);
        }
    }

    @Override
    public void runConsole() {
        try {
            DaemonThread dt = new DaemonThread();
            dt.setDaemon(true);
            dt.start();
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
            }

        }catch (Exception e){}
    }
}
