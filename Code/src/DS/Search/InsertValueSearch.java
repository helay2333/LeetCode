package DS.Search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,5,5,7,8,9};
        int ret = InsertValueSearch(arr,0,arr.length - 1, 4);
        System.out.println(ret);
    }
    public static int InsertValueSearch(int[] arr, int left,int right, int findVal){
        //条件不对的话可能会越界
        if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left)*(findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if(midVal < findVal) {
            return InsertValueSearch(arr,mid + 1, right,findVal);
        }else if (midVal > findVal) {
            return InsertValueSearch(arr,left, mid - 1,findVal);
        }else {
            return mid;
        }
    }
}
