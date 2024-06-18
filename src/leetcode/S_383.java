package leetcode;

public class S_383 {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            char[] counter=new char[128];
            for(int i=0;i<magazine.length();i++){
                char c=magazine.charAt(i);
                counter[c]++;
            }
            for(int i=0;i<ransomNote.length();i++){
                char c=ransomNote.charAt(i);
                if(counter[c]>0){
                    counter[c]--;
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}
