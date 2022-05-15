package Algorithm.Sort;

import java.util.Arrays;

/**
 * @author Green写代码
 * @date 2022-05-13 18:50
 */
public class MergeSort {

    public static void main(String[] args) {

        sort(0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int begin, int end) {
        if(end - begin < 2) return ;
        int mid = (begin + end) >> 1;
        sort(begin, mid);//[0,mid)
        sort(mid, end);
        merge(begin,mid,end);
    }
    private static int[] arr = new int[]{22,44,1,2,88,67};
    private static int[] left = new int[arr.length];
    private static void merge(int begin,int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;
        //备份左边数组
        for(int i = li; i < le; i++) {
            left[i] = arr[begin + i];
        }
        while(li < le) {
            if(ri < re && left[li] > arr[ri]) {//保证稳定性
                arr[ai++] = arr[ri++];
            }else {
                arr[ai++] = left[li++];
            }
        }

    }

}
