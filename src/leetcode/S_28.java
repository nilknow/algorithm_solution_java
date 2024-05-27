package leetcode;

import util.Assert;

public class S_28 {
    interface Solution {
        int strStr(String haystack, String needle);
    }

    static class Solution1 implements Solution {
        @Override
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }

    static class Solution2 implements Solution {
        @Override
        public int strStr(String haystack, String needle) {
            int hayLen = haystack.length();
            int neeLen = needle.length();
            if (hayLen < neeLen) {
                return -1;
            }

            for (int i = 0; i < hayLen - neeLen + 1; i++) {
                for (int j = 0; j < neeLen; j++) {
                    if (haystack.charAt(i + j) == needle.charAt(j)) {
                        if (j == neeLen - 1) {
                            return i;
                        }
                    } else {
                        break;
                    }
                }
            }

            return -1;
        }
    }

    static class Solution_KMP implements Solution {

        @Override
        public int strStr(String haystack, String needle) {
            int[] next = new int[needle.length()];
            next[0] = 0;
            int prefix = 0;
            int i = 1;
            while (i < needle.length()) {
                if (needle.charAt(prefix) == needle.charAt(i)) {
                    prefix++;
                    next[i] = prefix;
                    i++;
                } else {
                    if (prefix == 0) {
                        next[i] = 0;
                        i++;
                    } else {
                        prefix = next[prefix - 1];
                    }
                }
            }

            i = 0;
            int j = 0;
            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                } else if (j > 0) {
                    j = next[j - 1];
                } else {
                    i += 1;
                }

                if (j == needle.length()) {
                    return i - j;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution_KMP();
        int i1 = solution.strStr("sadbutsad", "sad");
        Assert.eq(i1, 0);
        int i2 = solution.strStr("hello", "helo");
        Assert.eq(i2, -1);
        int i3 = solution.strStr("hello", "ll");
        Assert.eq(i3, 2);
        int i4 = solution.strStr("a", "a");
        Assert.eq(i4, 0);
    }
}
