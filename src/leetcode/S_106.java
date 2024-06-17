package leetcode;

import util.Assert;

import java.util.HashMap;
import java.util.Map;

public class S_106 {
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
        private Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int len = inorder.length - 1;
            for (int i = 0; i <= len; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(postorder, 0, len, 0, len);
        }

        private TreeNode buildTree(int[] postorder, int inorderStart, int inorderEnd,
                                   int postorderStart, int postorderEnd) {
            if (postorderStart > postorderEnd) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postorderEnd]);
            int inorderRootIndex = map.get(root.val);
            int leftSize = inorderRootIndex - inorderStart;
            root.right = buildTree(postorder, inorderRootIndex + 1, inorderEnd, postorderStart + leftSize, postorderEnd - 1);
            root.left = buildTree(postorder, inorderStart, inorderStart + leftSize - 1, postorderStart, postorderStart + leftSize - 1);
            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        TreeNode treeNode = solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        Assert.eq(treeNode.val, 3);
        Assert.eq(treeNode.left.val, 9);
        Assert.eq(treeNode.right.val, 20);
        Assert.eq(treeNode.right.left.val, 15);
        Assert.eq(treeNode.right.right.val, 7);
    }
}
