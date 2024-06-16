package leetcode;

public class S_226 {

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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            } else if (root.left == null && root.right == null) {
                return root;
            } else {
                TreeNode t;
                t = root.left;
                root.left = root.right;
                root.right = t;
                invertTree(root.left);
                invertTree(root.right);
                return root;
            }
        }
    }
}
