package leetcode;

import util.Assert;

public class S_6 {
    private static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            StringBuilder[] sbs = new StringBuilder[numRows];
            for (int i = 0; i < sbs.length; i++) {
                sbs[i] = new StringBuilder();
            }
            int idx = 0;
            int flag = -1;
            for (int i = 0; i < s.length(); i++) {
                sbs[idx].append(s.charAt(i));
                if (idx == 0 || idx == numRows - 1) {
                    flag *= -1;
                }
                idx += flag;
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                ans.append(sbs[i].toString());
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ans1 = solution.convert("PAYPALISHIRING", 3);
        Assert.eq(ans1, "PAHNAPLSIIGYIR");
        String ans2 = solution.convert("AB", 1);
        Assert.eq(ans2, "AB");
    }
}
