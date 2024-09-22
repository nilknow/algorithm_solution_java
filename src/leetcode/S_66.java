package leetcode;

public class S_66 {
    static class Solution {
        // todo can be optimized. arraycopy after loop, if so we don't need the special check
        public int[] plusOne(int[] digits) {
            if(isSpecial(digits)){
                int[] newDigits=new int[digits.length+1];
                for(int i=1;i<digits.length+1;i++){
                    newDigits[i]=0;
                }
                newDigits[0]=1;
                return newDigits;
            }
            int carry=1;
            for(int i=0;i<digits.length;i++){
                if(carry==0){
                    return digits;
                }
                int digit=digits[digits.length-1-i];
                if(digit==9){
                    digits[digits.length-1-i]=0;
                    carry=1;
                }else{
                    digits[digits.length-1-i]+=1;
                    carry=0;
                }
            }
            return digits;
        }

        private boolean isSpecial(int[] digits){
            for(int i=0;i<digits.length;i++){
                if(digits[i]!=9){
                    return false;
                }
            }
            return true;
        }
    }
}
