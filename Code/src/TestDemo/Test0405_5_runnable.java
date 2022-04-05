package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-05 18:04
 * /**
 *  * 创建多线程的方式二：实现Runnable接口
 *  * 1.创建一个实现了Runnable接口得类
 *  * 2.实现类去实现Runnable中的抽象方法:run()
 *  * 3.创建实现类的对象
 *  * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 *  * 5.通过Thread类的对象调用start()
 *  */
class MThread implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2== 0){
                System.out.println(Thread.currentThread().getName()+i);//此时不能直接写getName
            }
        }
    }
}
public class Test0405_5_runnable {
    public static void main(String[] args) {
        MThread myThread = new MThread();
        Thread t1 = new Thread(myThread);//t1是线程，这里调用的是当前线程的run，但是内部实现的时候调用了Runnable类型的target的run
        t1.start();
        //再启动一个线程
        Thread t2 = new Thread(myThread);
        t2.start();
    }
}
