package leetcode;

import util.Assert;

public class S_55 {
    static class Solution {
        public boolean canJump(int[] nums) {
            if(nums.length==1){
                return true;
            }
            if(nums[0]==0){
                return false;
            }
            int maxDistance=nums[0];
            for(int i=1;i<nums.length;i++){
                if(i>maxDistance){
                    return false;
                }
                int num=nums[i];
                if(i+num>maxDistance){
                    maxDistance=i+num;
                    if(maxDistance>=nums.length){
                        return true;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        boolean canJump = solution.canJump(new int[]{0});
        Assert.eq(canJump,true);
        boolean canJump2 = solution.canJump(new int[]{2, 0});
        Assert.eq(canJump2, true);
    }
}
