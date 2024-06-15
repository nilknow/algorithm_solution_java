package leetcode;

import util.Assert;

public class S_209 {
    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int start = 0;
            int end = 0;
            int ans = Integer.MAX_VALUE;
            int sum = 0;
            while (end < nums.length) {
                sum += nums[end];
                while (sum >= target) {
                    ans = Math.min(ans, end - start + 1);
                    sum -= nums[start++];
                }
                end++;
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.minSubArrayLen(7, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Assert.eq(1, ans);
    }
}
