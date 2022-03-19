package leetcode;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minCount = 10000;
        int count = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum+=nums[j];
                // System.out.printf(sum+" ");
                if(sum >= target) {
                    count = j - i + 1;
                    break;
                }
            }
            // System.out.println(count);
            // System.out.println();
            if(minCount > count){
                minCount = count;
            }
        }
        return minCount;
    }
}
