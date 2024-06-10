package leetcode;

import util.Assert;

public class S_167 {
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i=0;
            int j=numbers.length-1;
            while(i<j){
                int sum=numbers[i]+numbers[j];
                if(sum==target){
                    return new int[]{i+1,j+1};
                }else if(sum>target){
                    j--;
                }else{
                    i++;
                }
            }
            return new int[]{-1,-1};
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={2,7,11,15};
        int[] result=solution.twoSum(nums,9);
        Assert.eq(result[0],1);
        Assert.eq(result[1], 2);
    }
}
