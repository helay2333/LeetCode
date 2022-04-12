package TestDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Green写代码
 * @date 2022-04-11 14:46
 */
public class Test0411_5_Funtional {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("啊","吃饭啊","as","qw");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
               return  s.contains("啊");
            }
        });
        System.out.println(filterStrs);
        System.out.println("================");
        List<String> filterStrs2 = filterString(list,s->s.contains("a"));
        System.out.println(filterStrs2);
    }
    public static void main1(String[] args) {
        happTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("快乐快乐"+aDouble);
            }
        });
        System.out.println("============");
        happTime(500,money -> System.out.println("快乐"));
    }
    public static void happTime(double money, java.util.function.Consumer<Double> con){
        con.accept(money);
    }
    //根据规则过滤字符串，此规则由Predicate方法决定
    public static List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}

interface cc{

}
//class a implements