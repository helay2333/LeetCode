package TestDemo;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 你得写代码
 * @date 2022-04-09 16:30
 */


public class Test0409_5_genericlast {
    public static void main(String[] args) {
        //类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?>list = null;//通用结构
        list = list1;
        list = list2;
        print2(list1);
        print2(list2);

    }
    public static void print2(List<?>list){
        Iterator<?>iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
    public static void print(List<Object>list){
        Iterator<Object> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void main1(String[] args) {
        //类A是类B的父类，G(A)和G(B)二者不具备父子关系，二者是并列关系
//        补充:类A是类B的父类，那么A(G)是B(G)的父类
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        Order22<Object> objectOrder22 = new Order22<>();
        Order22<String> stringOrder22 = new Order22<>();
//        objectOrder22 = stringOrder22;出错

        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;
        list1 = list3;
        list2 = list3;
    }
}
