package leetcode;

import util.Assert;

public class S_122 {
    static class Solution {
        public int maxProfit(int[] prices) {
            int profit=0;
            for(int i=1;i<prices.length;i++){
                int t=prices[i]-prices[i-1];
                if(t>0){
                    profit+=t;
                }
            }
            return profit;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int maxProfit = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        Assert.eq(maxProfit, 7);
    }
}
