package com.xuzz.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java的多线程通信有Lock，wait/notify，Semaphore三种方式，以一道常见面试题来简单演示这三种多线程通信方式。
 两个线程循环间隔打印指定内容，一个打印从1到52的数字，一个打印从A到Z的字母，打印输出如下：
 * Created by xuzz on 2017/4/17.
 */
public class Test1 {
    public void synWithLock(){
//        new Thread(new LockThread1()).start();
//        new Thread(new LockThread2()).start();
        ExecutorService es = Executors.newCachedThreadPool();
        System.out.println("使用lock condition");
        es.execute(new Test1.LockThread1());
        es.execute(new Test1.LockThread2());
        System.out.println("使用Object wait/notify");
        es.execute(new Test1.WaitNotify1());
        es.execute(new Test1.WaitNotify2());
        es.shutdown();
    }
    public void synWithWait(){

    }
    public void synWithSemap(){

    }

    private final Lock lock = new ReentrantLock();
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2=lock.newCondition();
    private static char currentThread = 'A';
    private final Object t = new Object();

    private class LockThread1 implements  Runnable
    {
        public void run(){
            for(int i=1;i<=52;i++)
            {
                lock.lock();
                try {
                    while(currentThread!='A') {
                        condition1.await();
                    }
                    System.out.println(i);
                    if(i%2==0)
                    {
                        currentThread='B';
                        condition2.signal();
                    }
                }
                catch (InterruptedException e)
                {}
                finally {
                    lock.unlock();
                }
            }
        }
    }

    private class LockThread2 implements  Runnable
    {
        public void run() {
            for(char ch='A';ch<='Z';ch++){
                lock.lock();
                try {
                    while(currentThread!='B') {
                        condition2.await();
                    }

                    System.out.println(ch);
                    currentThread='A';
                    condition1.signal();
                }
                catch (InterruptedException e)
                {

                }
                finally {
                    lock.unlock();
                }
            }
        }
    }

    private class WaitNotify1 implements  Runnable
    {
        public void run() {
            for(int i=1;i<=52;i++)
            {
                synchronized (t) {
                    try {
                        while(currentThread!='A') {
                            t.wait();
                        }
                    }
                    catch(InterruptedException e)
                    {

                    }

                    System.out.println(i);
                    if (i % 2 == 0) {
                        currentThread='B';
                        t.notify();
                    }
                }
            }
        }
    }
    private class WaitNotify2 implements  Runnable
    {
        public void run() {
            for(char ch='A';ch<='Z';ch++)
            {
                synchronized (t) {
                    try {
                        while(currentThread!='B') {
                            t.wait();
                        }
                    }
                    catch(InterruptedException e)
                    {

                    }

                    System.out.println(ch);
                    currentThread='A';
                    t.notify();
                }
            }
        }
    }
}
