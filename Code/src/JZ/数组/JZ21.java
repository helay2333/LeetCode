package JZ.数组;

import java.util.Arrays;

/**
 * @author Green写代码
 * @date 2022-08-13 15:35
 */
public class JZ21 {
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            while(left <= right && nums[left] % 2 == 1){
                left++;
            }
            while(left <= right && nums[right] % 2 == 0){
                right--;
            }
            if(left < right) swap(nums, left, right);
        }
        return nums;
    }
    public static void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] ans = {1,2,3,4};
        int[] arr = exchange(ans);
        System.out.println(Arrays.toString(arr));
    }
}
