package com.xuzz.study.io;

/**
 * Created by xuzz on 2017/4/19.
 */
public class EnumTest {

    public void Entry()
    {
        d(PaymentSettleState.FAIL);
    }
    private void d(PaymentSettleState payState)
    {
        System.out.println("e is : "+payState);
    }
}
