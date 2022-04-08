package TestDemo;

import java.util.*;

/**
 * @author 你得写代码
 * @date 2022-04-08 17:57
 */
public class Test0408_6_Set {
    public static void main(String[] args) {
        Set set = new TreeSet();
        set.add(456);
        set.add(123);
//        set.add("AA");
//        set.add("BB");
//        set.add(new Person2("Tom",12));
        set.add(123);
//        System.out.println(set);
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void main2(String[] args) {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("BB");
        set.add(new Person2("Tom",12));
        set.add(123);
//        System.out.println(set);
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void main1(String[] args) {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("BB");
        set.add(new Person2("Tom",12));
        set.add(123);
//        System.out.println(set);
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
