package leetcode;

import util.Assert;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class S_20 {
    static class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');

            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (map.containsValue(cur)) {
                    stack.push(cur);
                } else {
                    char c = map.get(cur);
                    Character cc = stack.peek();
                    if (cc == null) {
                        return false;
                    }
                    if (cc != c) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean valid = solution.isValid("()");
        Assert.eq(valid, true);
        boolean valid2 = solution.isValid("]");
        Assert.eq(valid2, false);
    }
}
