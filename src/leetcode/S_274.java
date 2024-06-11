package leetcode;

import util.Assert;

import java.util.Arrays;

public class S_274 {
    static class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int maxH=0;
            for(int i=0;i<citations.length;i++){
                int h=i+1;
                int leastCit = citations[citations.length - i - 1];
                if(leastCit >=h){
                    maxH=h;
                }else{
                    break;
                }
            }
            return maxH;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int hIndex = solution.hIndex(new int[]{3, 0, 6, 1, 5});
        Assert.eq(hIndex,3);
        int hIndex2 = solution.hIndex(new int[]{11, 15});
        Assert.eq(hIndex2, 2);
    }
}
