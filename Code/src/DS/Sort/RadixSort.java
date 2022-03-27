package DS.Sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = { 53, 3, 542, 748, 14, 214};
        RadixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void RadixSort(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();
        //获得了最大数的长度，然后我们就根据这个来循环桶排序就好

        //防止溢出
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[10];

        for(int i = 0,n = 1; i < maxLength; i++,n *=10) {
            for (int value : arr) {
                int index = value / n %10;
                bucket[index][bucketCount[index]] = value;
                bucketCount[index]++;
            }
            int x = 0;
            for(int k = 0; k < bucketCount.length; k++){
                if(bucketCount[k] !=0) {
                    for(int l = 0; l <bucketCount[k]; l++){
                        arr[x++] = bucket[k][l];
                    }
                }
                bucketCount[k] = 0;//置零
            }
        }
    }
}
