package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class S_71 {
    static class Solution {
        public String simplifyPath(String path) {
            String[] names = path.split("/");
            Deque<String> stack = new ArrayDeque<>();
            for (String name : names) {
                if ("..".equals(name)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!name.isEmpty() && !".".equals(name)) {
                    stack.push(name);
                }
            }

            if (stack.isEmpty()) {
                return "/";
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append('/');
                sb.append(stack.pollLast());
            }
            return sb.toString();
        }
    }
}
