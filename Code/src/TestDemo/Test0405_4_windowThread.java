package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-05 17:54
 */
class Window extends Thread{
    static private int ticket = 100;//这个得是共同的才可以

    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+":卖票，票号为"+ticket);
                ticket --;
            }else{
                break;
            }
        }
    }
}
public class Test0405_4_windowThread {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
