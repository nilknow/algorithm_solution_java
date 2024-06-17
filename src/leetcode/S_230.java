package leetcode;

public class S_230 {
    private class TreeNode {
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

    class Solution {
        int res, k;

        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (--k == 0) {
                res = root.val;
            }
            dfs(root.right);
        }
    }
}
