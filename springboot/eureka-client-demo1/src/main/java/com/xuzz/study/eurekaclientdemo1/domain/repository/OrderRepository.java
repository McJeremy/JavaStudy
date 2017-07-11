package com.xuzz.study.eurekaclientdemo1.domain.repository;

import java.util.Collection;

/**
 * Created by win10 on 2017/7/11.
 */
public interface OrderRepository<Order,String> extends  Repository<Order,String> {
    boolean containsName(String name);
    public Collection<Order> findByName(String name) throws Exception;
    public Collection<Order> findByUserId(String userId) throws Exception;
}
