package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-06 19:49
 */
class Window44 extends Thread{
    static private int ticket = 100;//这个得是共同的才可以
    private static Object obj = new Object();
    @Override
    public void run() {
        while(true){
            show();
        }
    }

    private static synchronized void show() {
        //此时的this可能有三个，所以方法需要是静态的。
        //此时的同步监视器就是当前类
        if(ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":卖票，票号为"+ticket);
            ticket --;
        }
    }
}
public class Test0406_9_windowThread {
    public static void main(String[] args) {
        Window44 t1 = new Window44();
        Window44 t2 = new Window44();
        Window44 t3 = new Window44();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

