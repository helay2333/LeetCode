package DS.Sort;

import java.util.Arrays;

public class MergetSort {
    public static void main(String[] args) {
        int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
        int[] tmp = new int[arr.length];
        MergetSort(arr,0, arr.length - 1,tmp);
        System.out.println(Arrays.toString(arr));
    }
    public static void MergetSort(int[] arr, int left, int right, int []tmp) {
            if(left >= right) return ;
            int mid = (left + right) / 2;//中间索引
            MergetSort(arr,left,mid, tmp);
            MergetSort(arr,mid+1,right,tmp);
            //合并子区间
            Merge(arr,left,mid,right,tmp);

    }
    public static void Merge(int []arr, int left,int mid, int right,int[]tmp){
        int begin1 = left,end1 = mid;
        int begin2 = mid + 1,end2 = right;
        int tp = left;
        while(begin1 <= end1 && begin2 <= end2){
            if(arr[begin1] < arr[begin2]){
                tmp[tp++] = arr[begin1++];
            }else {
                tmp[tp++] = arr[begin2++];
            }
        }
        while(begin1 <= end1) {
            tmp[tp++] = arr[begin1++];
        }
        while(begin2 <= end2) {
            tmp[tp++] = arr[begin2++];
        }
        //这里是因为前面复制的tp=left
        for(int j = left; j <= right; j++){
            arr[j] = tmp[j];
        }
    }
}
