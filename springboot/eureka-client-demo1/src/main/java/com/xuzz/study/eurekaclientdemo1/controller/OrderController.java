package com.xuzz.study.eurekaclientdemo1.controller;

import com.xuzz.study.eurekaclientdemo1.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by win10 on 2017/7/11.
 */
@RestController
@RequestMapping("/v1/user")
public class OrderController {
    protected static final Logger logger=Logger.getLogger(OrderController.class.getName());

    protected OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService)
    {
        this.orderService=orderService;
    }

    @RequestMapping(value="/{id}")
    @ResponseBody
    public Object findById(@PathVariable("id") String id)
    {
        try {
            return orderService.findByUserId(id);
        }catch (Exception ex)
        {

        }
        return null;
    }
}
