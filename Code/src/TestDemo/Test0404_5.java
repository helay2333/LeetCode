package TestDemo;

/**
 * @author 你得写代码
 * @date 2022-04-04 17:58
 */
public class Test0404_5 {
    public static void main(String[] args) {
        System.out.println(Fly.MAX);
        System.out.println(Fly.MAX);
    }
}
interface Fly{
    public static final int MAX = 7900;
    int MIN = 1;//省略修饰符

    //抽象方法
    public abstract void fly();
    //省略public abstract
    void stop();
}
interface attack{
    public abstract void Attack();
}
class Phone implements Fly,attack,CC{
    @Override
    public void fly() {
        System.out.println("起飞");
    }

    @Override
    public void Attack() {
        System.out.println("发泡");
    }

    @Override
    public void stop() {
        System.out.println("减速");
    }

    @Override
    public void method1() {

    }
    @Override
    public void method2() {

    }
}


interface AA{
    void method1();
}
interface BB{
    void method2();
}
interface CC extends AA,BB{

}