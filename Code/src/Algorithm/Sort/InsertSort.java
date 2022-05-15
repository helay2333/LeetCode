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
    public static void main2(String[] args) {
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
//    使用二分搜索优化
    static int[] arr = new int[]{10,5,2,6,80,11};

    public static void main(String[] args) {
//        int[] arr = new int[]{10,5,2,6,80,11};

        for(int begin = 1; begin < arr.length; begin++) {
            int v = arr[begin];
            int index = search(begin);
            System.out.println(index);
            for(int i = begin; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = v;
        }
        System.out.println(Arrays.toString(arr));
    }
    private static int search(int index) {
        int v = arr[index];
        int begin = 0;
        int end = index;
        while(begin < end) {
            int mid = (begin + end) >> 1;
            if(v < arr[mid]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
