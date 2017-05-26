package com.xuzz.study.thread;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xuzz on 2017/3/27.
 */
public class ProducerConsume2 {
    /**
     * 使用await/signal来实现
     *
     */

    private static int MAX_SIZE=100;
    //产品容器
    private LinkedList<Object> storage=new LinkedList<Object>();

    private Lock lock =new ReentrantLock();
    private final Condition full =lock.newCondition();
    private final Condition empty = lock.newCondition();

    public void produce(int num)
    {
        lock.lock();
        while(storage.size()+num<MAX_SIZE)
        {
            System.out.println("剩余容量不足，不能生成");
            try
            {
                // 由于条件不满足，生产阻塞
                full.await();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= num; ++i)
        {
            storage.add(new Object());
        }

        System.out.println("【已经生产产品数】:" + num + "/t【现仓储量为】:" + storage.size());
        full.signalAll();
        empty.signalAll();
        lock.unlock();
    }

    public void consume(int num)
    {

        lock.lock();
        while(storage.size() < num)
        {
            System.out.println("仓库余量不足，不能消费");
            try {
                empty.await();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= num; ++i)
        {
            storage.remove();
        }

        System.out.println("【已经消费产品数】:" + num + "/t【现仓储量为】:" + storage.size());

        // 唤醒其他所有线程
        full.signalAll();
        empty.signalAll();

        // 释放锁
        lock.unlock();
    }
}
