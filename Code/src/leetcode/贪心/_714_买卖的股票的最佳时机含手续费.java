package leetcode.贪心;

public class _714_买卖的股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        //我们将手续费算在购买股票的时候
        int in = prices[0] + fee;
        int maxSum = 0;
        for(int i = 1; i < prices.length; i++){
            in = Math.min(prices[i] + fee, in);
            if(prices[i] > in){
                maxSum += prices[i] - in;
                in = prices[i];
            }
        }
        return maxSum;
    }
}