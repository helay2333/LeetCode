package TestDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 你得写代码
 * @date 2022-04-06 16:49
 */
class Window3 implements Runnable{
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            try{
                //调用lock()方法,锁定，这样就可以单线程执行了
                lock.lock();
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ticket);
                    ticket--;
                }else{
                    break;
                }
            }
            finally {
                lock.unlock();//解锁
            }
        }
    }
}
public class Test0406_2_Lock {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }
}
