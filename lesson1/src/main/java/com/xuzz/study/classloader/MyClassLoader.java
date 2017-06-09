package com.xuzz.study.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by win10 on 2017/6/5.
 */
public class MyClassLoader extends ClassLoader {
    private String classDir;
    public MyClassLoader(){}
    public MyClassLoader(String classDir){
        this.classDir = classDir;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPathFile = classDir+"/"+name+".class";
        try {
            FileInputStream fileInputStream=new FileInputStream(classPathFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            encodeAndDecode(fileInputStream,bos);
            byte[] classByte = bos.toByteArray();
            return defineClass(classByte,0,classByte.length);
        }
        catch (Exception e)
        {

        }
        return super.findClass(name);
    }

    /**
     * 加密和解密算法
     * @param is
     * @param os
     * @throws Exception
     */
    private static void encodeAndDecode(InputStream is, OutputStream os) throws Exception{
        int bytes = -1;
        while((bytes = is.read())!= -1){
            bytes = bytes ^ 0xff;//和0xff进行异或处理
            os.write(bytes);
        }
    }
}
