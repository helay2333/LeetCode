package TestDemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 你得写代码
 * @date 2022-04-10 14:00
 */
public class Test0410_2_IP {
    public static void main(String[] args) {

        server();
        client();
    }
    public static void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            serverSocket = new ServerSocket(8899);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            //不建议，可能有乱码，因为有中文
//        byte[] buffer = new byte[20];
//        int len;
//        while((len = is.read(buffer))!=-1){
//            String str = new String(buffer,0,len);
//            System.out.println(str);
//        }
            baos = new ByteArrayOutputStream();
            //存储再底层这个类的数组中，如果大小不够会自动扩容。最后会将内容拼接再一起的
            byte[] buffer = new byte[5];
            int len;
            //read是一个阻塞式的方法
            while((len = is.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
    public static void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);
            os = socket.getOutputStream();
            os.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main1(String[] args) {
        try {
            InetAddress inte1 = InetAddress.getByName("192.168.19.14");
            System.out.println(inte1);
            InetAddress inte2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inte2);
            InetAddress inte3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inte3);
            InetAddress inte4 = InetAddress.getLocalHost();
            System.out.println(inte4);

            System.out.println(inte2.getHostName());
            System.out.println(inte2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
