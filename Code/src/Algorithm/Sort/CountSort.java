package Algorithm.Sort;

import java.util.Arrays;

/**
 * @author Green写代码
 * @date 2022-05-16 08:36
 */
public class CountSort {
    private static int[] arr = new int[]{23,55,11,65,32,67,100};

    public static void main(String[] args) {
        sort();
        System.out.println(Arrays.toString(arr));
    }
    protected static void sort(){
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        int[] counts = new int[1 + max];
        for(int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        //根据整数出现次数，对整数排序
        int index = 0;
        for(int i = 0; i < counts.length; i++) {
            while(counts[i]-- > 0){
                arr[index++] = i;
            }
        }
    }
}
