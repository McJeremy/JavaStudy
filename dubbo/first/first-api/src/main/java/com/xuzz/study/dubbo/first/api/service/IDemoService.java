package com.xuzz.study.dubbo.first.api.service;

import java.util.List;

/**
 * Created by win10 on 2017/5/26.
 */
public interface IDemoService {

    List<String> getPermissions(Long id);

}
