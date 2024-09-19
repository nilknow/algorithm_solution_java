package leetcode;

public class S_198 {
    static class Solution {
        public int rob(int[] nums) {
            return rob(nums,0);
        }

        private int rob(int[] nums,int idx){
            if(idx>nums.length-1){
                return 0;
            }
            int v1=nums[idx]+rob(nums,idx+2);
            if(idx+1>nums.length-1){
                return v1;
            }
            int v2=nums[idx+1]+rob(nums,idx+3);
            return Math.max(v1,v2);
        }
    }
}
