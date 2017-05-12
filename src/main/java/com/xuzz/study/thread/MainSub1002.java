package com.xuzz.study.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by win10 on 2017/5/12.
 */
public class MainSub1002 {
    //主线程跑2次，子线程跑10次，如此跑100次
    private static final Object obj=new Object();
    private static String flag="main";  //线程通信标识

    public static void runWithWait()
    {
        //子线程运行
        new Thread(new Runnable() {
            public void run() {
                for(int i=1;i<=100;i++)
                {
                    synchronized (obj)
                    {
                        if(flag!="sub")
                        {
                            try {
                                obj.wait();
                            }catch (InterruptedException e){}
                        }
                        for(int j=1;j<=10;j++)
                        {
                            System.out.println("子线程："+j);
                        }
                        flag="main";
                        obj.notify();
                    }
                }
            }
        }).start();
        for(int k=1;k<=100;k++)
        {
            synchronized (obj)
            {
                if(flag!="main") {
                    try {
                        obj.wait();
                    }catch (InterruptedException e){}
                }
                for(int j=1;j<=2;j++)
                {
                    System.out.println("主线程："+j);
                }
                flag="sub";
                obj.notify();
            }
        }
    }

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition mainCondition=lock.newCondition();
    private static final Condition subCondition=lock.newCondition();
    public static void runWithCondition()
    {
        new Thread(new Runnable() {
            public void run() {
                for(int i=1;i<=100;i++) {
                    lock.lock();
                    if(flag!="sub") {
                        try {
                            subCondition.await();
                        }catch (InterruptedException e){}
                    }
                    for(int j=1;j<=10;j++)
                    {
                        System.out.println("子线程："+j);
                    }
                    flag="main";
                    subCondition.signalAll();
                    mainCondition.signalAll();
                    lock.unlock();
                }
            }
        }).start();

        for(int i=1;i<=100;i++)
        {
            lock.lock();
            if(flag!="main") {
                try {
                    mainCondition.await();
                }catch (InterruptedException e){}
            }
            for(int j=1;j<=2;j++)
            {
                System.out.println("主线程："+j);
            }
            flag="sub";
            subCondition.signalAll();
            mainCondition.signalAll();
            lock.unlock();
        }
    }
}
