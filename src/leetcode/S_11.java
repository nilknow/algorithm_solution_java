package leetcode;

public class S_11 {
    static class Solution {
        public int maxArea(int[] height) {
            int l = 0;
            int r = height.length - 1;
            int ans = 0;
            while (l < r) {
                int area = Math.min(height[l], height[r]) * (r - l);
                ans = Math.max(ans, area);
                if (height[r] > height[l]) {
                    l++;
                } else if (height[r] < height[l]) {
                    r--;
                } else {
                    l++;
                    r--;
                }
            }
            return ans;
        }
    }
}
