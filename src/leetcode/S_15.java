package leetcode;

import util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S_15 {
    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for (int first = 0; first < nums.length - 2; first++) {
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                int second = first + 1;
                int third = nums.length - 1;
                while (second < third) {
                    int sum = nums[first] + nums[second] + nums[third];
                    if (sum == 0) {
                        ans.add(List.of(nums[first], nums[second], nums[third]));
                        while (second < third && nums[second] == nums[second + 1]) {
                            second++;
                        }
                        while (second < third && nums[third] == nums[third - 1]) {
                            third--;
                        }
                        second++;
                        third--;
                    } else if (sum < 0) {
                        second++;
                    } else {
                        third--;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Assert.eq(ans.size(), 2);
    }
}
