package com.xuzz.study.io;

/**
 * 付款单状态
 */
public enum PaymentSettleState
{

    /**
     * 未付款
     */
    UN_PAY(0),
    /**
     * 付款处理中
     */
    IN_TREATMENT(1),

    /**
     * 付款失败
     */
    FAIL(2),

    /**
     * 付款完成
     */
    CMPLETE(3),

    /**
     * 成功
     */
    SUCCESS(4),

    /**
     * 转入退款
     */
    REFUND(5);

    private Integer value;

    private PaymentSettleState(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
