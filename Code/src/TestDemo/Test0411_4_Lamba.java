package TestDemo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Green写代码
 * @date 2022-04-11 13:34
 */
public class Test0411_4_Lamba {
    public static void main(String[] args) {
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(c1.compare(15,23));

        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\");

        Comparator<Integer> com2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(16,8));
    }
    public static void main4(String[] args) {
        Consumer<String>c1 = (s) ->{
            System.out.println(s);
        };
        c1.accept("aaa");
        System.out.println("========");
        Consumer<String>c2 = s ->{
            System.out.println(s);
        };
        c2.accept("eee");
    }
    public static void main3(String[] args) {
        Consumer<String> c1 = (String s) ->{
            System.out.println(s);
        };
        c1.accept("？？？");
        Consumer<String> c2 = (s) ->{
            System.out.println(s);
        };
        c2.accept("...");

        //类型推断
        ArrayList<String>list = new ArrayList<>();
        int[] arr = {1,2,3};
    }
    public static void main2(String[] args) {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("我是t");
        System.out.println("==========");
        Consumer<String>c1 = (String s) ->{
            System.out.println(s);
        };
        c1.accept("我是t");
    }
    public static void main1(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱天安门");
            }
        };
        r1.run();
        System.out.println("===============");
        //lambda
        Runnable r2 = () -> System.out.printf("我爱故宫");
        r2.run();
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o,Integer o2) {
                return Integer.compare(o,o2);
            }
        };
        int compare1 = com.compare(12,21);
        System.out.println(compare1);
        System.out.println("==============");
        Comparator<Integer> com2 = (o, o2) ->Integer.compare(o,o2);
        int compare2 = com2.compare(12,21);
        System.out.println(compare1);
        System.out.println("==============");
        Comparator<Integer> com3 = Integer :: compare;
        int compare3 = com3.compare(12,21);
        System.out.println(compare1);

    }
}
