package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-06 19:44
 */
class Window33 implements Runnable{
    private int ticket = 100;
    Object obj = new Object();//同一把锁
    private synchronized void show(){
        //同步方法中，依旧是监视器的，只是我们没有显示出来，同步监视器依旧是this
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket);
            ticket--;
        }
    }
    @Override
    public  void run() {
        while (true) {
            show();
        }
    }
}
public class Test0406_8_windowThread {
    public static void main(String[] args) {
        Window33 w = new Window33();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}

