package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-06 16:38
 */
public class Test0406_1_deathread {
    public static void main(String[] args){
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        //创建匿名继承
        new Thread(){
            @Override
            public void run() {
                //同步监视器
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }

            }
        }.start();
        //实现runnable接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                //同步监视器
                synchronized (s2){
                    s1.append("c");
                    s2.append("3");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1){
                        s1.append("d");
                        s2.append("4");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}
