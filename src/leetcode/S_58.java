package leetcode;

public class S_58 {
    private static class Solution {
        public int lengthOfLastWord(String s) {
            s=s.trim();
            int len=s.length();
            int wLen=0;
            for(int i=len-1;i>=0;i--){
                if(s.charAt(i)==' '){
                    return wLen;
                }else{
                    wLen++;
                }
            }
            return wLen;
        }
    }
}
