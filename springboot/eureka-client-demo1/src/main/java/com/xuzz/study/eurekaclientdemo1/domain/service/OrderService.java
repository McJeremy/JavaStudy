package com.xuzz.study.eurekaclientdemo1.domain.service;

import com.xuzz.study.eurekaclientdemo1.domain.entity.Order;

import java.util.Collection;

/**
 * Created by win10 on 2017/7/11.
 */
public interface OrderService {
    Collection<Order> findByUserId(String userId) throws Exception;
}
