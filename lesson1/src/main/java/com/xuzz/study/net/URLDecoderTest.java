package com.xuzz.study.net;

import com.xuzz.study.core.IStudy;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by xuzz on 2016/10/22.
 */
public class URLDecoderTest implements IStudy {
    @Override
    public void runConsole() {
        try {
            String keyword= "%C4%E3%BA%C3%A3%AC%CE%D2%CA%C7%D0%EC%D6%BE%D4%F3";
            System.out.println(URLDecoder.decode(keyword,"UTF-8"));

            String urlStr = "你好，我是徐志泽";
            System.out.println(URLEncoder.encode(urlStr, "GBK"));
        }catch(Exception e)
        {}
    }
}
