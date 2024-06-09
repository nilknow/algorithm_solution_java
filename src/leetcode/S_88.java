package leetcode;

import util.Assert;

public class S_88 {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i=m-1;
            int j=n-1;
            int p=m+n-1;
            int cur;
            while(i>=0||j>=0){
                if(j==-1){
                    cur=nums1[i--];
                }else if(i==-1){
                    cur=nums2[j--];
                }else if(nums1[i]>nums2[j]){
                    cur=nums1[i--];
                }else{
                    cur=nums2[j--];
                }
                nums1[p--]=cur;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        solution.merge(nums1,3,nums2,3);
        Assert.eq(nums1[0],1);
        Assert.eq(nums1[1],2);
        Assert.eq(nums1[2],2);
        Assert.eq(nums1[3],3);
        Assert.eq(nums1[4],5);
        Assert.eq(nums1[5],6);
    }
}
