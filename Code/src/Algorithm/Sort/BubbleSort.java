package Algorithm.Sort;

import java.util.Arrays;

/**
 * @author Green写代码
 * @date 2022-05-10 20:41
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 13, 56, 32, 86 ,23};
        for(int end = arr.length - 1; end > 0; end--) {
            for(int begin = 1; begin <= end; begin++) {
                if(arr[begin] < arr[begin - 1]) {
                    int tmp = arr[begin];
                    arr[begin] = arr[begin - 1];
                    arr[begin - 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
