package TestDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author 你得写代码
 * @date 2022-04-08 14:44
 */

/**
 * Collection接口中声明的方法的测试
 *
 * 结论：
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 */
public class Test0408_3_Collection {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        //添加元素
        coll.add("AA");
        coll.add("BB");
        coll.add("CC");
        coll.add("DD");
        coll.add("SS");
        coll.add(123);//自动装箱
        System.out.println(coll.size());

        //addAll(Collection coll1):将对象coll1集合中的所有元素添加当前集合
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);
        //清空
//        coll.clear();
        System.out.println(coll.isEmpty());
        //contains(Object obj):判断当前集合中是否包含obj
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("AA")));//判断的值是否相等，equals。这里是true是因为String里面重写了equals。
        //如果使用的是其他自定义的类，那么使用相同值初始化的时候，返回的是false，因为equal里面调用的是==。除非重写equals

        //containsAll(Collection coll1):判断形参coll1中所有元素是否都存在于当前集合中
        Collection coll2 = Arrays.asList(123,456,789);
        System.out.println(coll.containsAll(coll2));

        //remove(Object obj) 移除元素，找到obj元素，返回true或者false。如果是移除对象，需要重写equals
        System.out.println(coll.remove(123));
        System.out.println(coll);

        //removeAll(COllection coll1):从当前集合中移除coll1中元素  ---- 差集
        System.out.println(coll2);
        coll.removeAll(coll2);
        System.out.println(coll);

        //retainAll(Collection coll2):获取当前集合和coll2集合的交集，并返回当前集合
        coll1.retainAll(coll2);
        System.out.println(coll1);

        //equals(Object obj):要想返回true，要当前元素和obj相同，有序无序就看是不是list
        Collection coll3 = Arrays.asList(123,456,789);
        System.out.println(coll2.equals(coll3));

        //hasCode：返回当前元素的哈希值
        System.out.println(coll.hashCode());

        //toArray:将集合转化成数组
        Object[] arr = coll.toArray();
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        //扩展：数组 ----> 集合 调用Arrays静态方法asList()
        List<String> strings = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(strings);
        //注意这两个
        List<int[]> ints = Arrays.asList(new int[]{123, 456});
        System.out.println(ints.size());
        List<Integer> integers = Arrays.asList(new Integer[]{123, 456});
        System.out.println(integers.size());

        //iterator() :返回Iterator接口的实例，用于遍历集合元素。
    }
}
