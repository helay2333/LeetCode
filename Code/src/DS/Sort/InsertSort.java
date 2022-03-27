package DS.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void InsertSort1(int[] arr){
        for(int i = 0; i < arr.length - 1; i++) {
            int insertVal = arr[i + 1];
            int insertIndex = 0;
            while(insertIndex<=i && insertVal >= arr[insertIndex]) {
                insertIndex++;
            }
            arr[i+1] = arr[insertIndex];
            arr[insertIndex] = insertVal;
        }
    }
    public static void InsertSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int insertVal = arr[i + 1];
            int insertIndex = i;
            //这一步是将大于后面这个要插入的数值全部往后移，然后我们保存的这个insertVal就放到她应该在的位置了
            while(insertIndex >=0 && insertVal < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }
    //1秒
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i =0; i < 80000; i++) {
            arr[i] = (int)(Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(date1);
        System.out.println("排序前时间为"+data1Str);
        InsertSort(arr);
        Date date2 = new Date();
        String data2Str = simpleDateFormat.format(date2);
        System.out.println("排序后时间为"+data2Str);
//        int[] arr = {3,6,1,2,7,2,8,9};
//        InsertSort(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
