package Algorithm.Sort;

/**
 * @author Green写代码
 * @date 2022-05-15 19:53
 */
public class QuickSort {
    private int[] arr = new int[]{22,43,12,66,880};
    private void sort(int begin, int end) {
        if(end - begin < 2) return ;
        int mid = pivotIndex(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }
    private int pivotIndex(int begin, int end) {
        int v = arr[begin];
        end--;//end指向最后一个元素
        while(begin < end) {
            while(begin < end) {
                if(v < arr[end]) {
                    end--;
                } else {
                    arr[begin++] = arr[end];
                    break;
                }
            }
            while(begin < end) {
                if(v > arr[begin]) {
                    begin++;
                } else {
                    arr[end--] = arr[begin];
                    break;
                }
            }
        }
        arr[begin] = v;
        return begin;
    }
}
