package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-06 19:31
 */
class Window11 extends Thread{
    static private int ticket = 100;//这个得是共同的才可以
    private static Object obj = new Object();
    //继承的方式是new了三个对象，那么此时是需要将obj设置成static的
    @Override
    public void run() {

        while(true){
            synchronized (obj){
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":卖票，票号为"+ticket);
                    ticket --;
                }else{
                    break;
                }
            }
        }
    }
}
public class Test0406_7_windowThread {
    public static void main(String[] args) {
        Window11 t1 = new Window11();
        Window11 t2 = new Window11();
        Window11 t3 = new Window11();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
