package DS.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    //O(n^2)
    public static void bubblesort(int[] arr){
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
//            System.out.println("第"+(i+1)+"次排序");
//            System.out.println(Arrays.toString(arr));
            if(!flag){
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i =0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前时间为"+data1Str);
        bubblesort(arr);
        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后时间为"+data2Str);

//        int[] arr = {3,9,-1,10,-2};
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(Arrays.toString(arr));
//        bubblesort(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
