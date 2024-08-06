package leetcode;

import util.Assert;

import java.util.ArrayDeque;
import java.util.Deque;

public class S_151 {
    //it can also be solved by twice reverse
    private static class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            Deque<String> stack = new ArrayDeque<>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == ' ') {
                    if (!sb.isEmpty()) {
                        String word = sb.toString();
                        stack.push(word);
                        sb.setLength(0);
                    }
                }else{
                    sb.append(c);
                }
            }
            if (!sb.isEmpty()) {
                stack.push(sb.toString());
            }

            sb.setLength(0);
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
                if (!stack.isEmpty()) {
                    sb.append(' ');
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String input = "the sky is blue";
        Solution solution = new Solution();
        String output = solution.reverseWords(input);
        Assert.eq(output,"blue is sky the");
    }
}
