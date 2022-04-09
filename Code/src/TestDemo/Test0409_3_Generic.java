package TestDemo;

import java.util.*;

/**
 * @author 你得写代码
 * @date 2022-04-09 14:50
 */
public class Test0409_3_Generic {
    public static void main(String[] args) {
        Map<String ,Integer> map = new HashMap<String,Integer>();
        map.put("Tom",222);
        map.put("QQ",111);
        map.put("We",545);
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "-------" + value);
        }
    }
    public static void main2(String[] args) {
        //类型不能是基本数据类型，是包装类
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(78);
        arrayList.add(78);
        arrayList.add(33);
        arrayList.add(88);
//        arrayList.add("SS");//编译时进行类型检查

        //遍历
        for (Integer in : arrayList){
            //避免强转操作
            int stuscore = in;
            System.out.println(stuscore);
        }

        //遍历2
        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            int stuscore = iterator.next();
            System.out.println(stuscore);
        }
    }
    public static void main1(String[] args) {
        ArrayList list = new ArrayList();
        list.add(78);
        list.add(32);
        list.add(77);
        list.add(88);
        list.add(99);
        //问题一：类型不安全
        list.add("Tom");
        for(Object score : list){
            //问题二：强转时有可能出现ClassCastException
            int stuscore = (int)score;
            System.out.println(stuscore);
//            System.out.println(score);
        }
    }
}
