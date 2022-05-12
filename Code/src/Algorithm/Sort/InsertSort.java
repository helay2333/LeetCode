package Algorithm.Sort;

import java.util.Arrays;

/**
 * @author Green写代码
 * @date 2022-05-12 15:02
 */
public class InsertSort {
    public static void main1(String[] args) {
        int[] arr = new int[]{10,5,2,6,80,11};
        for(int begin = 1; begin < arr.length; begin++) {
            int cur = begin;
            if(cur > 0 && arr[begin] < arr[begin - 1]) {
                int tmp = arr[begin];
                arr[begin] = arr[begin - 1];
                arr[begin - 1] = tmp;
                cur--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
//    优化
    public static void main(String[] args) {
        int[] arr = new int[]{10,5,2,6,80,11};
        for(int begin = 1; begin < arr.length; begin++) {
            int cur = begin;
            int V = arr[cur];
            while(cur > 0 && arr[begin] < arr[begin - 1]) {
                arr[cur] = arr[cur - 1];
                cur--;
            }
            arr[cur] = V;
        }
        System.out.println(Arrays.toString(arr));
    }
}
