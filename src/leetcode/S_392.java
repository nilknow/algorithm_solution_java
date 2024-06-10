package leetcode;

import util.Assert;

public class S_392 {
    static class Solution {
        public boolean isSubsequence(String s, String t) {
            int i=0;
            int j=0;
            while(i<s.length()&&j<t.length()){
                if(s.charAt(i)==t.charAt(j)){
                    i++;
                    j++;
                }else{
                    j++;
                }
            }
            return i == s.length();
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        boolean isSubsequence = solution.isSubsequence("abc", "ahbgdc");
        Assert.eq(isSubsequence,true);
    }
}
