package com.xuzz.study.eurekaclientdemo1.domain.repository;

import com.xuzz.study.eurekaclientdemo1.domain.entity.Entity;
import com.xuzz.study.eurekaclientdemo1.domain.entity.Order;
import org.springframework.stereotype.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by win10 on 2017/7/11.
 */
@org.springframework.stereotype.Repository("orderRepository")
public class InMemOrderRepository implements OrderRepository<Order,String> {
    private Map<String, Order> entities;

    public InMemOrderRepository()
    {
        entities=new HashMap<>();
        Order order=new Order("1","订单1","1","5","从地铁导天堂", LocalDate.now(), LocalTime.now(),new BigDecimal("8888.00"));
        entities.put("1",order);

        order=new Order("2","订单2","1","9","北京到上海", LocalDate.now(), LocalTime.now(),new BigDecimal("888.00"));
        entities.put("2",order);

        order=new Order("3","订单3","2","8","从高新到龙泉", LocalDate.now(), LocalTime.now(),new BigDecimal("88.00"));
        entities.put("3",order);
    }

    @Override
    public void add(Order entity) {
        entities.put(entity.getId(),entity);
    }

    @Override
    public void remove(String id) {
        if(entities.containsKey(id))
        {
            entities.remove(id);
        }
    }

    @Override
    public boolean containsName(String name) {
        try
        {
            return this.findByName(name).size()>0;
        }
        catch (Exception ex){}
        return false;
    }

    @Override
    public void update(Order entity) {
        if(entities.containsKey(entity.getId()))
        {
            entities.put(entity.getId(),entity);
        }
    }

    @Override
    public boolean contains(String id) {
        return entities.containsKey(id);
    }

    @Override
    public Entity get(String id) {
        return entities.get(id);
    }

    @Override
    public Collection<Order> findByName(String name) throws Exception {
        Collection<Order> orders=new ArrayList();
        int noOfChars = name.length();
        entities.forEach((k,v)->{
            if(v.getName().toLowerCase().contains(name.toLowerCase().subSequence(0,noOfChars)))
            {
                orders.add(v);
            }
        });
        return orders;
    }

    @Override
    public Collection<Order> getAll() {
        return entities.values();
    }

    @Override
    public Collection<Order> findByUserId(String userId) throws Exception {
        Collection<Order> orders=new ArrayList();
        entities.forEach((k,v)->{
            if(v.getId().equals(userId))
            {
                orders.add(v);
            }
        });
        return orders;
    }
}
