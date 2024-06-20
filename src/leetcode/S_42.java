package leetcode;

import util.Assert;

public class S_42 {
    static class Solution {
        public int trap(int[] height) {
            int len=height.length;

            int[] left=new int[len];
            left[0]=height[0];
            for(int i=1;i<len;i++){
                left[i]=Math.max(left[i-1],height[i]);
            }

            int[] right=new int[len];
            right[len-1]=height[len-1];
            for(int i=len-2;i>=0;i--){
                right[i]=Math.max(right[i+1],height[i]);
            }

            int sum=0;
            for(int i=0;i<len;i++){
                sum+=Math.min(left[i],right[i])-height[i];
            }
            return sum;
        }
    }

    //todo there is O(1) space complex solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        Assert.eq(ans,6);
    }
}
