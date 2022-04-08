package TestDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author 你得写代码
 * @date 2022-04-08 15:37
 */
public class Test0408_4_Interator {
    public static void main(String[] args) {

    }
    public static void main3(String[] args) {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person2("Jey",12));
        coll.add(new String("qqq"));
        coll.add(false);
        //内部仍然是调用了迭代器
        for(Object obj : coll){
            System.out.println(obj);
        }
    }
    public static void main2(String[] args) {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person2("Jey",12));
        coll.add(new String("qqq"));
        coll.add(false);
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }
        iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static void main1(String[] args) {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person2("Jey",12));
        coll.add(new String("qqq"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        //方式一
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        //System.out.println(iterator.next());//抛异常NoSuchElementException

        //方式二：
        iterator = coll.iterator();
        for(int i = 0; i < coll.size(); i++){
            System.out.println(iterator.next());
        }

        //方式三：推荐
        iterator = coll.iterator();
        while(iterator.hasNext()){
            //调用next()会造成什么？指针下移，然后将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }


    }
}
