package com.xuzz.study.dubbo.first.provider.service.impl;

import com.xuzz.study.dubbo.first.api.service.IDemoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win10 on 2017/5/26.
 */
public class DemoServiceImpl implements IDemoService {
    @Override
    public List<String> getPermissions(Long id) {
        List<String> demo = new ArrayList<String>();
        demo.add(String.format("Permission_%d", id - 1));
        demo.add(String.format("Permission_%d", id));
        demo.add(String.format("Permission_%d", id + 1));
        return demo;
    }
}


