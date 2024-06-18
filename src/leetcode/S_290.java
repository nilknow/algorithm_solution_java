package leetcode;

import util.Assert;

import java.util.HashMap;
import java.util.Map;

public class S_290 {
    static class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] strings = s.split(" ");
            String[] patterns = pattern.split("");
            if (strings.length != patterns.length) {
                return false;
            }
            Map<String, String> map = new HashMap<>(strings.length);
            Map<String, String> rmap = new HashMap<>(strings.length);
            for (int i = 0; i < patterns.length; i++) {
                String p = patterns[i];
                String is = strings[i];
                if (!map.containsKey(p)&&!rmap.containsKey(is)) {
                    map.put(p, is);
                    rmap.put(is, p);
                } else {
                    if (!map.containsKey(p)) {
                        return false;
                    }
                    if(!rmap.containsKey(is)) {
                        return false;
                    }
                    if (!map.get(p).equals(is)||!rmap.get(is).equals(p)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean ans = solution.wordPattern("abba", "dog cat cat dog");
        Assert.eq(ans, true);
    }
}
