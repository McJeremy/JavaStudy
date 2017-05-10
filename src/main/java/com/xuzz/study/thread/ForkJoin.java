package com.xuzz.study.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by xuzz on 2017/4/7.
 */
public class ForkJoin {
    public static void forkJoin()
    {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask=new CountTask(1,100);
        Future<Integer> future = forkJoinPool.submit(countTask);

        try
        {
            System.out.println("并行计算的结果:"+future.get());

            System.out.println("看看是不是并行完了，猜到我");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
class CountTask extends RecursiveTask<Integer>
{
    public static final int threshold = 2;
    private int start;
    private int end;

    public CountTask(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        System.out.println("并行计算当前的线程:"+Thread.currentThread().getName());
        System.out.println("计算范围："+start+"-"+end);
        System.out.println("----------------------");
        /**
         * 如果体量足够小，就直接计算，不再fork
         */
        boolean canCompute = (end-start)<=threshold;
        if(canCompute)
        {
            for(int i=start;i<=end;i++)
            {
                sum+=i;
            }
        }
        else
        {
            int middle = (start+end)/2;
            CountTask left = new CountTask(start,middle);
            CountTask right = new CountTask(middle+1,end);
            left.fork();
            right.fork();

            sum = left.join()+right.join();
        }
        return sum;
    }
}
