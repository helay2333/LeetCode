package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Green写代码
 * @date 2022-04-12 13:53
 */
public class code77 {
    public static void main(String[] args) {
        List<ArrayList> list2 = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        list2.add(arr);
        list2.add(arr);
        list2.add(arr);
        System.out.println(list2);
        arr.remove(2);
        System.out.println(list2);
    }
}
