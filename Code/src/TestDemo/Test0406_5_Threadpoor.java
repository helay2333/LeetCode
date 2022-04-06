package TestDemo;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 你得写代码
 * @date 2022-04-06 17:58
 */
class NumThread2 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println(i);
        }
    }
}
class NumThread3 implements Runnable{
    @Override
    public void run() {
        for(int i = 100; i < 200; i++){
            System.out.println(i);
        }
    }
}
public class Test0406_5_Threadpoor {
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(10);//创建池子
        service.execute(new NumThread2());//适合Runnable
        service.execute(new NumThread3());
//        service.submit();//适合Callable
        service.shutdown();//关闭池子
    }
}
