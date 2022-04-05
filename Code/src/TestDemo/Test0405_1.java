package TestDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author 你得写代码
 * @date 2022-04-05 13:13
 */
public class Test0405_1 {
    public static void main(String[] args) throws MyException {
        Student232 s = new Student232();
        s.regist(123);

    }
    public static void main2(String[] args) throws FileNotFoundException, IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while(data != -1){
            System.out.print((char)data);
            data = fis.read();
        }

        fis.close();

    }
    public static void main1(String[] args) {
        try{
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("一定执行的代码");
        }
    }
}
class Student232{
    private int id;

    public void regist(int id) throws RuntimeException, MyException {
        if(id > 0){
            this.id = id;
        }else{
            throw new MyException("你输入的非法");
        }
    }

    @Override
    public String toString() {
        return "Student232{" +
                "id=" + id +
                '}';
    }
}
