package TestDemo;

import java.io.*;

/**
 * @author 你得写代码
 * @date 2022-04-09 19:36
 */
public class Test0409_7_IO {
    //
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer))!=-1){
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void main4(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //创建File类对象
            File srcFile = new File("hello.txt");
            File destFile = new File("hello1.txt");
            //创建输入流输出流对象
             fr = new FileReader(srcFile);
             fw = new FileWriter(destFile);
            //数据读入写出
            char[] cubf = new char[5];
            int len;
            while((len = fr.read(cubf))!=-1){
                fw.write(cubf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw!=null){
                try {
                    if(fw!=null)
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if(fr!=null)
                        fr.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        //关闭流资源
    }
    public static void main3(String[] args) {
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");

            //2.提供FileWriter的对象，用于数据的写出
            //append表示true，在原有基础上增加
            fw = new FileWriter(file, false);

            //3.写出的操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if (fw != null) {

                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

}
    public static void main2(String[] args){
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");

            //2.FIleReader流的实例化
            fr = new FileReader(file);
            //3.读入操作 ---> 一次性多读一些
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf))!=-1){
                //错误的写法
    //            for(int i = 0; i < cbuf.length; i++){
    //                System.out.println(cbuf[i]);
    //            }
                //正确的写法
                for(int i = 0; i < len; i++){
                    System.out.print(cbuf[i]);
                }
                //如果使用String
//                String str = new String(cbuf,0,len);
//                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //4.资源关闭

    }
    public static void main1(String[] args){
        FileReader fr = null;
        try {
            //1.提供实例化File的对象
            File file = new File("hello.txt");
            //2.提供具体的流
             fr = new FileReader(file);
            //3.数据的读入
            //read() -- > 返回读入的一个字符。如果达到文件末尾就返回-1
//        int data = fr.read();
//        while(data != -1){
//            System.out.println((char)data);
//            data = fr.read();
//        }
            int data;
            while((data = fr.read())!=-1){
                System.out.println((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //4.流的关闭操作
//        fr.close();





//        System.out.println(file.getAbsolutePath());
    }
}
