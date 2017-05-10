package com.xuzz.study.thread;

import com.xuzz.study.core.IStudy;

/**
 * Created by xuzz on 2016/10/22.
 */
public class DrawThread extends  Thread implements IStudy {

    private Account account;
    private double drawAccount; //模拟取钱的数

    public DrawThread(){}
    public DrawThread(String name,Account account,double drawAccount)
    {
        super(name);
        this.account=account;
        this.drawAccount=drawAccount;
    }

    public void run()
    {
        //synchorinized标识同步代码块，如果取消，则可能会出现余额为负数的情况。注意：是可能，而不是一定。

        synchronized(account) {
            if (account.getBalance() > drawAccount) {
                System.out.println(Thread.currentThread().getName() + "取钱成功，吐出钞票：" + drawAccount);

            /*

             */
                account.setBalance(account.getBalance() - drawAccount);
                System.out.println("余额为：" + account.getBalance());
            } else {
                System.out.println("余额不足，不能取了");
            }
        }
    }
    @Override
    public void runConsole() {
        Account ac =new Account("621232535",1000);

        new DrawThread("甲",ac,800).start();
        new DrawThread("乙",ac,800).start();
    }
}
