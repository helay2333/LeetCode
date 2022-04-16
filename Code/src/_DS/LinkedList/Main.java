package _DS.LinkedList;

/**
 * @author Green写代码
 * @date 2022-04-16 12:28
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer>list = new LinkedList<>();
        list.add(20);
        list.add(2);
        list.add(20);
        list.add(660);
        list.add(2,100000);
        System.out.println(list);
    }
}
