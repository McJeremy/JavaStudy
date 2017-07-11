package com.xuzz.study.eurekaclientdemo1.domain.entity;

import com.xuzz.study.eurekaclientdemo1.domain.vo.OrderVO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by win10 on 2017/7/11.
 */
public class Order extends Entity<String> {
    private OrderVO orderVO;
    private final String userId;
    private final String driverId;

    public Order(String id, String name, String userId, String driverId, String journey, LocalDate date, LocalTime time, BigDecimal amount)
    {
        super(id,name);
        this.orderVO=new OrderVO();
        this.userId=userId;
        this.driverId=driverId;
        this.orderVO.setJourney(journey);
        this.orderVO.setDate(date);
        this.orderVO.setTime(time);
        this.orderVO.setAmount(amount);
    }

    public OrderVO getOrderVO() {
        return orderVO;
    }

    public void setOrderVO(OrderVO orderVO) {
        this.orderVO = orderVO;
    }

    public String getUserId() {
        return userId;
    }

    public String getDriverId() {
        return driverId;
    }

    @Override
    public String toString()
    {
        return new StringBuffer("{id:").append(this.id)
                .append(",name:").append(this.name)
                .append(",userId:").append(this.userId)
                .append(",driverId:").append(this.driverId)
                .append(this.orderVO.toString())
                .append("}").toString();
    }
}
