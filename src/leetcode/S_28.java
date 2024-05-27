package leetcode;

import util.Assert;

public class S_28 {
    static class Solution {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i1 = solution.strStr("sadbutsad", "sad");
        Assert.eq(i1, 0);
        int i2 = solution.strStr("hello", "helo");
        Assert.eq(i2, -1);
    }
}
