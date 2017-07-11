package com.xuzz.study.eurekaclientdemo1.domain.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by win10 on 2017/7/11.
 */
public class OrderVO {
    private LocalDate date;
    private LocalTime time;
    private String journey;
    private BigDecimal amount;

    public  void OrderVO()
    {}

    @Override
    public String toString()
    {
        return new StringBuilder("date :").append(this.date)
                .append(",time:").append(this.time)
                .append(",journey:").append(this.journey)
                .append(".amount:").append(this.amount)
                .append("}").toString();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getJourney() {
        return journey;
    }

    public void setJourney(String journey) {
        this.journey = journey;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
