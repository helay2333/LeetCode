package TestDemo;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @author 你得写代码
 * @date 2022-04-09 17:17
 */
public class Test0409_6_File {
    public static void main(String[] args) {
        //1.创建一个File实例
        //相对路径创建：相对于当前目录
        File file = new File("hello.txt");
        //绝对路径:包含盘符
        File file1 = new File("E:\\");
        //
        System.out.println(file);
        System.out.println(file1);

        //
    }
}
