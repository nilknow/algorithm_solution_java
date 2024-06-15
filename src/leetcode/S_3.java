package leetcode;

import util.Assert;

public class S_3 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int start = 0;
            int end = 0;
            int ans = 0;
            int[] count = new int[128];
            while (end < s.length()) {
                while (end < s.length() && count[s.charAt(end)] < 1) {
                    count[s.charAt(end)]++;
                    end++;
                }
                ans = Math.max(ans, end - start);
                count[s.charAt(start)]--;
                start++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring("abcabcbb");
        Assert.eq(length, 3);
    }
}
