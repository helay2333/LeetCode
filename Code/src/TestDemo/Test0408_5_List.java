package TestDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 你得写代码
 * @date 2022-04-08 17:37
 */
public class Test0408_5_List {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person2("TT",12));
        list.add(456);
        System.out.println(list);

        //add(int index, Object ele);在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);

        //boolean addAll(int index, Collection eles);//从index位置开始将eles中所有元素添加当前集合中
        List list1 = Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list.size());
        list.add(list1);
        System.out.println(list.size());

        //indexOf
        int index = list.indexOf(123);
        System.out.println(index);

        //remove(index)：按照角标删除，或者对象删除。这是重载
        Object obj = list.remove(0);
        System.out.println(obj);//删除的元素
        System.out.println(list);

        //set()
        list.set(1,"CC");
        System.out.println(list);

        //subList(first,last);左闭右开的子集合,本身list是不会变的
        System.out.println(list.subList(2, 4));
    }
}
