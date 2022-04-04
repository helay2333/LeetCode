package TestDemo;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * @author 你得写代码
 * @date 2022-04-04 13:39
 */
//饿汉
public class Test0404_3 {
    public static void main(String[] args) {
        Order1 b1 = Order1.getInstance();
        Order1 b2 = Order1.getInstance();
        System.out.println(b1 == b2);//true
    }
    public static void main1(String[] args) {
        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
        System.out.println(b1 == b2);//true
    }
}
class Bank{
    //私有化构造器
    private Bank(){
    }
    private static Bank instance = new Bank();
    public static  Bank getInstance(){
        return instance;
    }
}
class Order1{
    private Order1(){

    }
    private static Order1 instance = null;
    public static Order1 getInstance(){
        if (instance == null) {//保证只有一份new
            instance = new Order1();
        }
        return instance;
    }
}