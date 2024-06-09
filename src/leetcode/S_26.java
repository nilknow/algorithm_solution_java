package leetcode;

import util.Assert;

public class S_26 {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums.length==1){
                return 1;
            }

            int quick=1;
            int slow=0;
            while(quick<nums.length){
                if(nums[quick]!=nums[slow]){
                    nums[++slow]=nums[quick];
                }
                quick++;
            }
            return slow+1;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1,1,2};
        int len=solution.removeDuplicates(nums);
        Assert.eq(len,2);
        int[] nums2={0,0,1,1,1,2,2,3,3,4};
        len=solution.removeDuplicates(nums2);
        Assert.eq(len, 5);
    }
}
