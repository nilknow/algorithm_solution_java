package leetcode;

import java.util.HashSet;
import java.util.Set;

public class S_202 {
    //todo Fast&Slow pointer pattern would be better
    private static class Solution {
        public boolean isHappy(int n) {
            Set<Integer> cache = new HashSet<>();
            int t = n;
            while (true) {
                t = splitAndCalc(t);
                if (cache.contains(t)) {
                    return false;
                } else if (t == 1) {
                    return true;
                } else {
                    cache.add(t);
                }
            }
        }

        private Integer splitAndCalc(int n) {
            String nStr = String.valueOf(n);
            String[] splitNStr = nStr.split("");
            Integer[] splitN = new Integer[splitNStr.length];
            for (int i = 0; i < splitNStr.length; i++) {
                splitN[i] = Integer.valueOf(splitNStr[i]);
            }
            int ans = 0;
            for (int num : splitN) {
                ans += num * num;
            }
            return ans;
        }
    }
}
