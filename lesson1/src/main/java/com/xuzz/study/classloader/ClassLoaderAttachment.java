package com.xuzz.study.classloader;

import java.util.Date;

/**
 * 需要被加载的类
 * Created by win10 on 2017/6/5.
 */
public class ClassLoaderAttachment extends Date {

    private static final long serialVersionUID = 8627644427315706176L;
    //打印数据
    @Override
    public String toString(){
        return "Hello ClassLoader!";
    }

}
