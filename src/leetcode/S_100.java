package leetcode;

public class S_100 {
    class TreeNode {
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
        //todo lazy to optimize the condition here.
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            } else if (p == null && q != null) {
                return false;
            } else if (p != null && q == null) {
                return false;
            } else if (p.val != q.val) {
                return false;
            } else if (p.left == null && q.left != null) {
                return false;
            } else if (p.left != null && q.left == null) {
                return false;
            } else if (p.right == null && q.right != null) {
                return false;
            } else if (p.right != null && q.right == null) {
                return false;
            } else if (p.left == null && q.left == null && p.right == null && q.right == null) {
                return true;
            } else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }
}
