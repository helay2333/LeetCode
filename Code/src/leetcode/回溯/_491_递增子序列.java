package leetcode.回溯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Green写代码
 * @date 2022-04-18 09:04
 */

class Solution {
    List<List<Integer>> returnArr = new ArrayList();
    List<Integer> path = new ArrayList();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return returnArr;
        }
        boolean [] used = new boolean[205];
        back(nums, 0, used);
        return returnArr;
    }
    public void back(int[] nums, int startindex, boolean[] used){
        if(path.size() > 1){
            //最少两个
            returnArr.add(new ArrayList(path));
        }
        for(int i = startindex; i < nums.length; i++){
            if(used[nums[i] + 100]==false){
                continue;
            }
            path.add(nums[i]);
            used[nums[i] + 100] = true;
            back(nums, i + 1, used);
            used[nums[i] + 100] = false;
            path.remove(path.size() - 1);

        }
    }
}

public class _491_递增子序列 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new Solution().findSubsequences(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}