package leetcode;

import util.Assert;

public class S_169 {
    static class Solution {
        public int majorityElement(int[] nums) {
            int count=1;
            int cur=nums[0];
            for(int i=1;i<nums.length;i++){
                if(nums[i]!=cur){
                    count--;
                }else{
                    count++;
                }
                if(count<0){
                    cur=nums[i];
                    count=0;
                }
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={3,2,3};
        int res=solution.majorityElement(nums);
        Assert.eq(res,3);
        int[] nums2={10,9,9,9,10};
        res=solution.majorityElement(nums2);
        Assert.eq(res, 9);
    }
}
