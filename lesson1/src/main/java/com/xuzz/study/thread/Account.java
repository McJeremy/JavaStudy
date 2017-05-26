package com.xuzz.study.thread;

/**
 * Created by xuzz on 2016/10/22.
 */
public class Account {
    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String accountNo ;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account target = (Account)o;
        return target.getAccountNo().equals(accountNo);
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
}
