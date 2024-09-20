package leetcode;

public class S_35 {
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left=0;
            int right=nums.length-1;
            int ans=nums.length;
            while(left<=right){
                int mid=((right-left)>>1)+left;
                if(nums[mid]>=target){
                    ans=mid;
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            return ans;
        }
    }
}
