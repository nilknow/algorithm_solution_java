package leetcode;

import util.Assert;

import java.util.ArrayList;
import java.util.List;

public class S_530 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public int getMinimumDifference(TreeNode root) {
            List<Integer> vals = new ArrayList<>();
            inorder(vals, root);

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < vals.size() - 1; i++) {
                min = Math.min(Math.abs(vals.get(i + 1) - vals.get(i)), min);
            }
            return min;
        }

        private void inorder(List<Integer> vals, TreeNode root) {
            if (root.left != null) {
                inorder(vals, root.left);
            }
            vals.add(root.val);
            if (root.right != null) {
                inorder(vals, root.right);
            }
        }
    }

    static class BetterSolutionFromOtherPeople {
        int res = Integer.MAX_VALUE;
        TreeNode pre = null;

        public void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            if (pre != null) res = Math.min(res, Math.abs(pre.val - root.val));
            pre = root;
            dfs(root.right);
        }

        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int ans = solution.getMinimumDifference(root);
        Assert.eq(ans, 1);
    }
}
