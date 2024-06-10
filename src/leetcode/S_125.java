package leetcode;

import util.Assert;

public class S_125 {
    static class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                char ci = s.charAt(i);
                if (isCharacter(ci)) {
                    i++;
                    continue;
                }
                char cj = s.charAt(j);
                if (isCharacter(cj)) {
                    j--;
                    continue;
                }

                if (ci == cj) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return true;
        }

        private char toLower(char c) {
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            return c;
        }

        private boolean isCharacter(char c) {
            boolean validChar = (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
            return !validChar;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean res1 = solution.isPalindrome("race a car");
        Assert.eq(res1, false);
        boolean res2 = solution.isPalindrome("0P");
        Assert.eq(res2, false);
    }
}
