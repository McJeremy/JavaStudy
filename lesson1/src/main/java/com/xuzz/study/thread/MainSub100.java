package com.xuzz.study.thread;

/**
 * 子线程循环10次，主线程循环100次，如此循环100次
 * Created by xuzz on 2017/3/31.
 */
public class MainSub100 {
    public void run()
    {
        final Business b = new Business();
        new Thread(new Runnable() {
            public void run() {
                threadExecute(b,"sub");
            }
        }).start();
        threadExecute(b,"main");
    }

    private void threadExecute(Business business,String threadType)
    {
        for(int i = 0; i < 100; i++) {
            try {
                if("main".equals(threadType)) {
                    business.main(i);
                } else {
                    business.sub(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Business
{
    private boolean flag = true;
    public synchronized void main(int loop) throws InterruptedException
    {
        while(flag)
        {
            this.wait();
        }
        for(int i=0;i<100;i++)
        {
            System.out.println("主线程第"+loop+"进入，本次进入循环第："+i+"次");
        }
        flag=true;
        this.notify();
    }

    public synchronized  void sub(int loop) throws InterruptedException
    {
        while(flag)
        {
            this.wait();
        }
        for(int i=0;i<10;i++)
        {
            System.out.println("子线程第"+loop+"进入，本次进入循环第："+i+"次");
        }
        flag=true;
        this.notify();
    }
}