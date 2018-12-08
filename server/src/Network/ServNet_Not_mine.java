package Network;

import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.net.*;
import java.util.Iterator;

public class ServNet_Not_mine {

    //监听端口
    int port = 6000;
    //缓冲区大小
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    //其它相关定义
    Selector selector;
    ServerSocketChannel channel;
    ServerSocket socket;


    public void Start() throws Exception {
        /*初始化一个Selector*/
        selector = Selector.open();
        /*打开通道*/
        channel = ServerSocketChannel.open();
        /*非阻塞模式*/
        channel.configureBlocking(false);
        /*本机IP*/
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        //InetAddress ip = InetAddress.getLocalHost();
        /*绑定IP和端口*/
        InetSocketAddress address = new InetSocketAddress(ip,port);
        socket = channel.socket();
        socket.bind(address);
        /*启动监听*/
        System.out.println("TCP服务器开始监听...");
        Listen();
    }

    /*停止*/
    public void Stop() throws Exception {
        channel.close();
        selector.close();
    }

    /*监听*/
    public void Listen() throws Exception {
        /*注册接收事件*/
        channel.register(selector,SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();
            /*轮询事件*/
            Iterator iter = selector.selectedKeys().iterator();
            while (iter.hasNext()) {
                SelectionKey key =  (SelectionKey)iter.next();
                iter.remove();
                /*事件分类处理*/
                if (key.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                    System.out.println("新终端已连接:"+ sc.getRemoteAddress());
                }
                else if (key.isReadable()) {
                    SocketChannel sc = (SocketChannel)key.channel();
                    int recvCount = sc.read(buffer);
                    if (recvCount > 0) {
                        byte[] arr = buffer.array();
                        System.out.println(sc.getRemoteAddress() + "发来数据: "+ new String(arr));
                        buffer.flip();
                    }
                    else {
                        sc.close();
                    }
                    buffer.clear();
                }

                else {

                }


            }

        }

    }

}