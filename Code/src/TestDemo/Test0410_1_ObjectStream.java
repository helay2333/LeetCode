package TestDemo;

import java.io.*;

/**
 * @author 你得写代码
 * @date 2022-04-10 11:20
 */
public class Test0410_1_ObjectStream {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("data.dat"));
            Object obj = ois.readObject();
            String str = (String)obj;
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    public static void main1(String[] args) {
        ObjectOutputStream oos = null;
        try {
            //序列化：将内存中的java对象保存到磁盘当中，或者通过网络传递
             oos = new ObjectOutputStream(new FileOutputStream("data.dat"));
            oos.writeObject(new String("我爱天安门"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
