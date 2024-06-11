package leetcode;

import util.Assert;

public class S_45 {
    static class Solution {
        public int jump(int[] nums) {
            int end=0;
            int rightmost=0;
            int steps=0;
            for (int i=0;i<nums.length-1;i++){
                rightmost=Math.max(rightmost,i+nums[i]);
                if(i==end){
                    end=rightmost;
                    steps++;
                }
            }
            return steps;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int steps = solution.jump(new int[]{2, 3, 1, 1, 4});
        Assert.eq(steps,2);
    }
}
