class Solution {
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