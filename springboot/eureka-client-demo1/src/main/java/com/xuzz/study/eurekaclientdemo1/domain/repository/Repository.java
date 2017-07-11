package com.xuzz.study.eurekaclientdemo1.domain.repository;

/**
 * Created by win10 on 2017/7/11.
 */
public interface Repository<TE,T> extends  ReadOnlyRepository<TE,T> {
    void add(TE entity);
    void remove(T id);
    void update(TE entity);
}
