package DS.Search;

import java.util.ArrayList;
import java.util.List;
public class BinarySearch {
    public static List<Integer> binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        List<Integer> returnList;
        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            //此时找到了，往前往后查找
            returnList = new ArrayList<Integer>();
            int tmp = mid - 1;
            while (tmp >= 0 && arr[tmp] == findVal) {
                tmp--;
            }
            tmp++;
            while(tmp <= mid){
                returnList.add(tmp++);
            }
            //右查找
            tmp = mid + 1;
            while (tmp <= right && arr[tmp] == findVal) {
                returnList.add(tmp);
                tmp++;
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,5,5,6,7,8,9,111,3333};
        List<Integer> ret = new ArrayList<Integer>();
        ret = binarySearch(arr,0,arr.length - 1,5);
        System.out.println(ret);
    }
}
