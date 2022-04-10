package TestDemo;

import java.io.*;

/**
 * @author 你得写代码
 * @date 2022-04-09 21:16
 */
public class Test0409_8_Buffered {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //造文件
            File srcFile = new File("aa.jpg");
            File destFile = new File("bb.jpg");
            //造流
            //1.造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.复制的细节
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            //要求：先关闭外层流，再关闭内存流
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的时候，会自动关闭内存流。可以省略
//        fos.close();
//        fis.close();
        }


    }
}
