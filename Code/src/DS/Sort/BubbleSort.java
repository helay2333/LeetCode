package DS.Sort;

import java.util.Arrays;

public class BubbleSort {
    //O(n^2)
    public static void main(String[] args) {
        int[] arr = {3,9,-1,10,-2};
        for(int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;//重置flag
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j+1] < arr[j]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    flag = true;//经过这里了，那么此时必然还不是有序的
                }
            }
            if(!flag){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
