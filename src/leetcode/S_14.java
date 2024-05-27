package leetcode;

import util.Assert;

import java.util.Arrays;
import java.util.Comparator;

public class S_14 {
    interface Solution {
        String longestCommonPrefix(String[] strs);
    }

    static class Solution1 implements Solution {

        @Override
        public String longestCommonPrefix(String[] strs) {
            int strsLen = strs.length;
            int minLen = Arrays.stream(strs).map(String::length)
                    .min(Comparator.comparingInt(a -> a)).get();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < minLen; i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strsLen; j++) {
                    if (strs[j].charAt(i) != c) {
                        return sb.toString();
                    }
                }
                sb.append(c);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution1();
        String res1 = solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        Assert.eq(res1, "fl");
        String res2 = solution.longestCommonPrefix(new String[]{"a"});
        Assert.eq(res2, "a");
    }
}
