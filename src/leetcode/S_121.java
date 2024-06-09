package leetcode;

import util.Assert;

public class S_121 {
    static class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit=0;
            int minPrice=Integer.MAX_VALUE;
            for(int i=0;i<prices.length;i++){
                int price=prices[i];
                if(price<minPrice){
                    minPrice=price;
                }else{
                    int profit=price-minPrice;
                    if(profit>maxProfit){
                        maxProfit=profit;
                    }
                }
            }
            return maxProfit;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] prices={7,1,5,3,6,4};
        int res=solution.maxProfit(prices);
        Assert.eq(res,5);
    }

}
