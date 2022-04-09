package TestDemo;

import java.util.*;

/**
 * @author 你得写代码
 * @date 2022-04-09 02:05
 */
public class Test0409_1_Map {
    public static void main(String[] args) {

    }
    public static void main2(String[] args) {
        //遍历key
        Map map  = new HashMap();
        map.put("AA",123);//新增put
        map.put(45,123);
        map.put("BB",123);
        map.put("AA",456);//修改
        map.put("CC",123);
        //遍历所有的key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("*****************");

        //遍历所有的values集：values()
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }
        //遍历所有的key-values
        //方式一：
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());

        }
        System.out.println("/");

        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "=====" + value);
        }
    }
    public static void main1(String[] args) {
        Map map  = new HashMap();
        map.put("AA",123);//新增put
        map.put(45,123);
        map.put("BB",123);
        map.put("AA",456);//修改
        map.put("CC",123);
        System.out.println(map);//{AA=456, BB=123, CC=123, 45=123}

        Map map1 = new HashMap();
        map1.put("CC",234);
        map1.put("DD",234);
        map.putAll(map1);
        System.out.println(map);//{AA=456, BB=123, CC=234, DD=234, 45=123}

        //按照指定key移除
        Object value = map.remove("CC");
        System.out.println(value);//234
        System.out.println(map);//{AA=456, BB=123, DD=234, 45=123}

//        map.clear();
        System.out.println(map.size());//0,map还在，只是没数据

        //get() --- 根据key获取value，没有就是null
        System.out.println(map.get("DD"));

        System.out.println(map.containsKey("BB"));
        System.out.println(map.containsValue(123));
    }
}
