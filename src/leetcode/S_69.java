package leetcode;

import util.Assert;

public class S_69 {
    static class Solution {
        public int mySqrt(int x) {
            int left=0;
            int right=x;
            while(left<=right){
                int mid=left+((right-left)>>1);
                if((long)mid*mid==x){
                    return mid;
                }else if((long)mid*mid>x){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            if((long)left*left>x){
                return left-1;
            }
            return left;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.mySqrt(8);
        Assert.eq(ans, 2);
        int ans2 = solution.mySqrt(2147395599);
        Assert.eq(ans2, 46339);
    }
}
