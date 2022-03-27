package DS.Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,1,1,4,4,4,7,7,7,2,3,7,79,-1};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int left, int right){
        int l = left;
        int r = right;
        int mid = arr[(l + r) / 2];
        while(l < r) {
            while(arr[l] < mid) {
                l++;
            }
            while(arr[r] > mid) {
                r--;
            }
            //相等的时候也需要退出循环
            if(l >= r) {
                break;
            }
            //交换变量
            arr[l] ^= arr[r];
            arr[r] ^=arr[l];
            arr[l] ^= arr[r];
            if (arr[l] == mid) {
                r--;
            }
            if(arr[r] == mid) {
                l++;
            }
        }
        l++;
        r--;
        if(left < r) {
            quickSort(arr,left,r);
        }
        if(right > l) {
            quickSort(arr,l,right);
        }
    }
}
