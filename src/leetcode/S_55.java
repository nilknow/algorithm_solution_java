package leetcode;

import util.Assert;

public class S_55 {
    static class Solution {
        public boolean canJump(int[] nums) {
            int rightmost=0;
            for(int i=0;i<nums.length;i++){
                if(i<=rightmost){
                    rightmost=Math.max(rightmost,i+nums[i]);
                    if(rightmost>=nums.length-1){
                        return true;
                    }
                }else{
                    return false;
                }
            }
            return false;
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
