package DS.Sort;

import java.util.Arrays;

public class Shellsort {
    public static void main(String[] args) {
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        ShellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void ShellSort(int[] arr) {
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++) {
                for(int j = i - gap; j >=0; j-=gap){
                    if(arr[j] > arr[j + gap]){
                        int tmp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = tmp;
                    }
                }
            }
        }
    }
    public static void ShellSort2(int[] arr) {
        for(int gap = arr.length/2;gap >0; gap/=2) {
            for(int i = gap; i < arr.length; i++) {
                int j = i;
                int tmp = arr[j];
                if(arr[j] < arr[j - gap]){
                    while(j - gap >=0 && tmp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j-=gap;
                    }
                    arr[j] = tmp;
                }
            }
        }
    }
}
