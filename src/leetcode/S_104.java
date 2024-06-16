package leetcode;

public class S_104 {
    public class TreeNode {
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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else if (root.left == null && root.right == null) {
                return 1;
            } else if (root.left != null && root.right != null) {
                return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
            } else if (root.left != null && root.right == null) {
                return maxDepth(root.left) + 1;
            } else {
                return maxDepth(root.right) + 1;
            }
        }
    }
}
