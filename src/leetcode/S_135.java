package leetcode;

import util.Assert;

public class S_135 {
    static class Solution {
        public int candy(int[] ratings) {
            int len = ratings.length;
            int[] left = new int[len];
            left[0] = 1;
            for (int i = 1; i < len; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            }

            for (int i = len - 1; i > 0; i--) {
                if (ratings[i - 1] > ratings[i]) {
                    left[i - 1] = Math.max(left[i] + 1, left[i - 1]); ;
                }
            }

            int sum = 0;
            for (int num : left) {
                sum += num;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.candy(new int[]{1, 3, 4, 5, 2});
        Assert.eq(ans, 11);
    }
}
