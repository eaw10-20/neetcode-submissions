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
    private int maxDiam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDiam(root);
        return maxDiam;
    }

    public int getDiam(TreeNode root){
        if(root == null) return 0;
        int lenLeft = getDiam(root.left);
        int lenRight = getDiam(root.right);
        maxDiam = Math.max((lenLeft + lenRight),maxDiam);
        return Math.max(lenLeft, lenRight)+1;
    }
}
