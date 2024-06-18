package leetcode;

import util.Assert;

import java.util.HashMap;
import java.util.Map;

public class S_1 {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }

            int[] ans = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                int num = nums[i];
                int need = target - num;
                if (map.containsKey(need) && map.get(need) != i) {
                    ans[0] = i;
                    ans[1] = map.get(need);
                    return ans;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.twoSum(new int[]{3, 2, 4}, 6);
        Assert.eq(ans[0], 1);
        Assert.eq(ans[1], 2);
    }
}
