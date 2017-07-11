package com.xuzz.study.eurekaclientdemo1.domain.service;

import com.xuzz.study.eurekaclientdemo1.domain.repository.Repository;

import java.util.Collection;

/**
 * Created by win10 on 2017/7/11.
 */
public abstract class BaseService<TE,T> extends ReadOnlyBaseService<TE,T> {
    private Repository<TE, T> repository;

    BaseService(Repository<TE, T> repository) {
        super(repository);
        this.repository = repository;
    }

    public void add(TE entity) throws Exception
    {
        repository.add(entity);
    }

    public Collection<TE> getAll()
    {
        return repository.getAll();
    }
}
