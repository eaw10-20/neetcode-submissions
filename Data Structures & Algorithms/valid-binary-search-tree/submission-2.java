/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean validateBST(TreeNode node, int max, int min){
        if(node.left != null){
            if(!validateBST(node.left,node.val,min)) return false; //DFS
            if(node.left.val >= node.val) return false; //validate immediate branch
            if(node.left.val <= min) return false; //check if on wrong side of tree
        }
        if(node.right != null){
            if(!validateBST(node.right,max,node.val)) return false; //DFS
            if(node.right.val <= node.val) return false; //validate immediate branch
            if(node.right.val >= max) return false; //check if on wrong side of tree
        }
        return true;
    }
}
