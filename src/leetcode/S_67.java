package leetcode;

import util.Assert;

public class S_67 {
    static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder ans=new StringBuilder();

            int maxLen=Math.max(a.length(),b.length());
            int carry=0;
            for(int i=0;i<maxLen;i++){
                carry+=i<a.length()?(a.charAt(a.length()-1-i)-'0'):0;
                carry+=i<b.length()?(b.charAt(b.length()-1-i)-'0'):0;
                ans.append((char)(carry%2+'0'));
                carry/=2;
            }
            if(carry>0){
                ans.append('1');
            }
            ans.reverse();

            return ans.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String ans = solution.addBinary("11", "1");
        Assert.eq(ans, "100");
    }
}
