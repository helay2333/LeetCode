package DS.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void SelectSort(int[] arr){
        int minIndex = 0;
        int min = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for(int j = i + 1; j < arr.length - 1; j++){
                if(arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
    //3秒
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i =0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前时间为"+data1Str);
        SelectSort(arr);
        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后时间为"+data2Str);
//        int[] arr = {3,2,1,6};
//        SelectSort(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
