package com.xuzz.study.eurekaclientdemo1.domain.repository;

import com.xuzz.study.eurekaclientdemo1.domain.entity.Entity;

import java.util.Collection;

/**
 * Created by win10 on 2017/7/11.
 */
public interface ReadOnlyRepository<TE,T> {
    boolean contains(T id);
    Entity get(T id);
    Collection<TE> getAll();
}
