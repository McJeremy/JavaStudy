package com.xuzz.study.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by win10 on 2017/6/8.
 */
public class BasicSelector {
    public void run () throws IOException
    {
        Selector selector=Selector.open();

        // 与Selector一起使用时，Channel必须处于非阻塞模式下。这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。而套接字通道都可以。
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);   //必须是非阻塞模式

        SelectionKey selectionKey= serverSocketChannel.register(selector, SelectionKey.OP_READ);
        while(true)
        {
            int readyChannel = selector.select();
            if(readyChannel==0)
            {
                continue;
            }
            Set selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();
            while(keyIterator.hasNext())
            {
                SelectionKey key =(SelectionKey) keyIterator.next();
                if(key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                } else if (key.isReadable()) {
                    // a channel is ready for reading
                } else if (key.isWritable()) {
                    // a channel is ready for writing
                }
            }
        }
    }
}
