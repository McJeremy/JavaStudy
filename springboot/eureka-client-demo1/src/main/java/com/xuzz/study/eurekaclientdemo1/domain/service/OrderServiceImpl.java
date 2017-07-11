package com.xuzz.study.eurekaclientdemo1.domain.service;

import com.xuzz.study.eurekaclientdemo1.domain.entity.Order;
import com.xuzz.study.eurekaclientdemo1.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by win10 on 2017/7/11.
 */
@Service("orderService")
public class OrderServiceImpl extends BaseService<Order,String> implements OrderService {
    private OrderRepository<Order,String> orderRepository;
    @Autowired
    public OrderServiceImpl(OrderRepository<Order,String> orderRepository)
    {
        super(orderRepository);
        this.orderRepository=orderRepository;
    }

    @Override
    public Collection<Order> findByUserId(String userId) throws Exception {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public void add(Order entity) throws Exception {
        orderRepository.add(entity);
    }

    @Override
    public Collection<Order> getAll() {
        return orderRepository.getAll();
    }
}
