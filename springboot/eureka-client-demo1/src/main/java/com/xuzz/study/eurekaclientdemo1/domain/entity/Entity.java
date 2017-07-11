package com.xuzz.study.eurekaclientdemo1.domain.entity;

/**
 * Created by win10 on 2017/7/11.
 */
public abstract class Entity<T> {
    T id;
    String name;

    public Entity(T id,String name)
    {
        this.id=id;
        this.name=name;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
