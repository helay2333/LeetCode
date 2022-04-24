package leetcode.贪心;

/**
 * @author Green写代码
 * @date 2022-04-22 22:06
 */
public class _45_跳跃游戏 {
    public int jump(int[] nums){
        if(nums.length == 0 || nums.length == 1 || nums == null){
            return 0;
        }
        int count = 0;//走的步数
        int curdistance = 0;//当前跳跃范围
        int maxdistance = 0;//最大跳跃范围
        for(int i = 0; i < nums.length; i++){
            //更新最大跳跃范围
            maxdistance = Math.max(maxdistance, i + nums[i]);
            if(maxdistance >= nums.length - 1){
                //此时表示加上当前的num[i]可以跳到末尾乐，需要count++，更新count
                count++;
                break;
            }
            if(i == curdistance){
                //表示即将超出当前的跳跃范围，那么就count++，扩大范围
                count++;
                curdistance = maxdistance;
            }
        }
        return count;
    }
}
