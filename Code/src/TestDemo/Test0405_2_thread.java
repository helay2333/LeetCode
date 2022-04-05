package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-05 16:45
 * thread的创建方式一
 */
class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i %2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i %2 == 1){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class Test0405_2_thread {
    public static void main(String[] args) {
//        MyThread1 myThread = new MyThread1();
//        MyThread2 myThread2 = new MyThread2();
//        myThread.start();
//        myThread2.start();
        //创建匿名子类
        new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    if(i %2 == 1){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    if(i %2 == 0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
    }
}
