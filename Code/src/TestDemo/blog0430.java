package TestDemo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Green写代码
 * @date 2022-04-30 20:11
 */
class Person6 implements Comparable{
    int age;//年龄
    int height;//身高

    public Person6(int age, int height) {
        this.age = age;
        this.height = height;
    }

    @Override
    public int compareTo(Object o) {
        return this.age - ((Person6)o).age;
    }

    @Override
    public String toString() {
        return "Person6{" +
                "age=" + age +
                ", height=" + height +
                '}';
    }
}
public class blog0430 {
    public static void main(String[] args) {
        Person6 p1 = new Person6(17,170);
        Person6 p2 = new Person6(13,160);
        Person6 p3 = new Person6(11,180);
        Person6[] arr = new Person6[3];
        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;
        Arrays.sort(arr, new Comparator<Person6>() {
            @Override
            public int compare(Person6 o1, Person6 o2) {
                return o1.height - o2.height;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    public static void main1(String[] args) {
        String[] str = new String[]{"AA","VV","QQ","BB"};
        System.out.println(Arrays.toString(str));
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
    }
}
