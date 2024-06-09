package leetcode;

import util.Assert;

public class S_27 {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            if(nums.length==0){
                return 0;
            }
            int quick=0;
            int slow=0;
            while(quick<nums.length){
                if(nums[quick]!=val){
                    nums[slow++]=nums[quick];
                }
                quick++;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={3,2,2,3};
        int len=solution.removeElement(nums,3);
        Assert.eq(len,2);
        int[] nums2={0,1,2,2,3,0,4,2};
        len=solution.removeElement(nums2, 2);
        Assert.eq(len, 5);
    }
}
