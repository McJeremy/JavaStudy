package com.xuzz.study.eurekaclientdemo1.domain.service;

import com.xuzz.study.eurekaclientdemo1.domain.repository.Repository;

/**
 * Created by win10 on 2017/7/11.
 */
public abstract class ReadOnlyBaseService<TE,T> {
    private Repository<TE,T> repository;
    ReadOnlyBaseService(Repository<TE,T> repository)
    {
        repository=repository;
    }
}
