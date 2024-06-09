package leetcode;

import util.Assert;

public class S_189 {
    static class Solution {
        public void rotate(int[] nums, int k) {
            k=k%nums.length;
            flip(nums,0,nums.length-k-1);
            flip(nums,nums.length-k,nums.length-1);
            flip(nums,0,nums.length-1);
        }

        private void flip(int[] nums,int from,int to){
            while(from<to){
                int t=nums[from];
                nums[from]=nums[to];
                nums[to]=t;
                from++;
                to--;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1,2,3,4,5,6,7};
        solution.rotate(nums, 3);
        Assert.eq(nums[0],5);
        Assert.eq(nums[1],6);
        Assert.eq(nums[2],7);
        Assert.eq(nums[3],1);
        Assert.eq(nums[4],2);
        Assert.eq(nums[5],3);
        Assert.eq(nums[6],4);
    }
}
