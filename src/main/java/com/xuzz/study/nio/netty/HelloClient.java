package com.xuzz.study.nio.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by win10 on 2017/5/23.
 */
public class HelloClient {
    public void connect() throws Exception
    {
        EventLoopGroup group = new NioEventLoopGroup();
        try
        {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                       socketChannel.pipeline().addLast(new TimeClientHandler());
                        }
                    });
            //异步链接服务器 同步等待链接成功
            ChannelFuture f = b.connect("127.0.0.1", 8000).sync();
            //等待链接关闭
            f.channel().closeFuture().sync();
        }
        finally {
            group.shutdownGracefully();
            System.out.println("客户端优雅的释放了线程资源...");
        }
    }
}
