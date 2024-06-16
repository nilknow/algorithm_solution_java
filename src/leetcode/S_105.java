package leetcode;

import java.util.HashMap;
import java.util.Map;

public class S_105 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int len=preorder.length;
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<len;i++){
                map.put(inorder[i],i);
            }
            return buildTree(preorder,inorder,0,len-1,0,len-1,map);
        }

        private TreeNode buildTree(int[] preorder,int[] inorder,int preorderLeft,int preorderRight,int inorderLeft,int inorderRight,Map<Integer,Integer> map){
            if(preorderLeft>preorderRight){
                return null;
            }

            TreeNode root=new TreeNode(preorder[preorderLeft]);
            int inorderRootIndex=map.get(preorder[preorderLeft]);
            int leftSize=inorderRootIndex-inorderLeft;
            root.left=buildTree(preorder,inorder,preorderLeft+1,preorderLeft+leftSize,inorderLeft,inorderRootIndex-1,map);
            root.right=buildTree(preorder,inorder,preorderLeft+leftSize+1,preorderRight,inorderRootIndex+1,inorderRight,map);
            return root;
        }
    }
}
