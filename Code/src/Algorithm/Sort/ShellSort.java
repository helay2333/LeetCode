package Algorithm.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Green写代码
 * @date 2022-05-16 08:02
 */
public class ShellSort {
    private static List<Integer> stepSequence;
    private static int[] arr = new int[]{11,54,21,78,22,44};

    public static void main(String[] args) {
        sort();
        System.out.println(Arrays.toString(arr));
    }
    private static void sort() {
        stepSequence = new ArrayList<>();
        int gap = arr.length;
        while((gap>>=1) > 0) {
            stepSequence.add(gap);
        }
        for(Integer step : stepSequence) {
            sort(step);
        }
    }
    private static void sort(int step) {
        for (int col = 0; col < step; col++) {
            //插入排序[0, arr.length]范围进行插入排序
            for(int begin = col+step; begin < arr.length; begin=begin+step) {
                int cur = begin;
                while(cur > 0 && arr[begin] < arr[begin - step]) {
                    int tmp = arr[begin];
                    arr[begin] = arr[begin - step];
                    arr[begin - step] = tmp;
                    cur-=step;
                }
            }
        }
    }
}
