package leetcode;

import util.Assert;

import java.util.Arrays;

public class S_205 {
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            Character[] map = new Character[128];
            Arrays.fill(map, null);
            Character[] tmap = new Character[128];
            Arrays.fill(tmap, null);
            if (s.length() != t.length()) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char sc = s.charAt(i);
                char tc = t.charAt(i);

                if (map[sc] == null && tmap[tc] == null) {
                    map[sc] = tc;
                    tmap[tc] = sc;
                } else {
                    if (map[sc] == null && tmap[tc] != null) {
                        return false;
                    } else if (map[sc] != null && tmap[tc] == null) {
                        return false;
                    } else if (map[sc] != tc || tmap[tc] != sc) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean ans1 = solution.isIsomorphic("badc", "baba");
        Assert.eq(ans1, false);
        boolean ans2 = solution.isIsomorphic("\u0000\u0000", "\u0000c");
        Assert.eq(ans2, false);
    }
}
