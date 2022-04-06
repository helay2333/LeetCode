package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-06 19:54
 * 使用同步机制将懒汉改变成线程安全
 */

public class Test0406_10_lanhan {


}
class Bank1{
    private Bank1(){

    }
    private static  Bank1 instance = null;
    //理解成getInstance是在run中执行的
    //两个线程同时判断成null进入if语句中，instance就是共享数据
    public static synchronized Bank1 getInstance(){
        //ctrl+alt+t
        if(instance == null){
            synchronized (Bank.class) {
                if(instance == null){
                    instance = new Bank1();
                }

            }
        }
        return instance;//为什么多加一层if，因为就不用进入到synchronized同步代码块了
        //直接return
    }
 }
