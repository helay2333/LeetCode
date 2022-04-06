package TestDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 你得写代码
 * @date 2022-04-06 17:42
 */
class NumThread implements Callable{
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;//装箱
    }
}
public class Test0406_4_Callable {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();
        try {
            //get方法返回值就是FutureTask构造器参数Callable实现类重写的call返回值
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
