package leetcode;

import util.Assert;

public class S_80 {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums.length==2){
                return 2;
            }
            int slow=2;
            int quick=2;
            while(quick<nums.length){
                if(nums[quick]!=nums[slow-2]){
                    nums[slow++]=nums[quick];
                }
                quick++;
            }
            return slow;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1,1,1,2,2,3};
        int len=solution.removeDuplicates(nums);
        Assert.eq(len,5);
    }
}
