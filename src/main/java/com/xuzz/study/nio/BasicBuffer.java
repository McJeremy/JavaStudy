package com.xuzz.study.nio;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by xuzz on 2017/4/5.
 */
public class BasicBuffer {

    public static void get() throws IOException
    {
        URL url = BasicBuffer.class.getResource("/data/nio-data.txt");
        String path = url.getFile();

        RandomAccessFile file = new RandomAccessFile(path, "rw");
//        RandomAccessFile file= new RandomAccessFile("/data/nio-data.txt","rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buffer= ByteBuffer.allocate(48);     //init a buffer

        /**
         * 写数据到Buffer有两种方式：
         从Channel写到Buffer。
         通过Buffer的put()方法写到Buffer里。
         */
        int byteReader = channel.read(buffer);  //read into buffer
        while(byteReader!=-1)
        {
            buffer.flip();  //从写模式转换为读模式
            while(buffer.hasRemaining())
            {
                /**
                 * 从Buffer中读取数据有两种方式：
                 从Buffer读取数据到Channel。
                 使用get()方法从Buffer中读取数据。
                 */
                System.out.print((char) buffer.get()); // read 1 byte at a time
            }

            buffer.clear();
            byteReader=channel.read(buffer);
        }

        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer writeBuffer =ByteBuffer.allocate(48);
        writeBuffer.put(newData.getBytes());
        writeBuffer.flip();
        while(writeBuffer.hasRemaining())
        {
            channel.write(writeBuffer);
        }
        file.close();
    }
}
