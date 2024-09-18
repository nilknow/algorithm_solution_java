package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class S_150 {
    static class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack=new ArrayDeque<>();
            for (String token : tokens) {
                switch (token) {
                    case "+" -> stack.push(stack.pop() + stack.pop());
                    case "-" -> stack.push(-stack.pop() + stack.pop());
                    case "*" -> stack.push(stack.pop() * stack.pop());
                    case "/" -> {
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(b / a);
                    }
                    default -> stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
    }
}
