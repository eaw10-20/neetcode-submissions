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

    private int counter;

    public int kthSmallest(TreeNode root, int k) {
        counter = k;
        return findSmallest(root);
    }

    private int findSmallest(TreeNode node){
        if(node == null) return -1;

        //check left
        int ret = findSmallest(node.left);
        if(ret >=0) return ret;

        //check node
        counter--;
        if(counter == 0) return node.val;

        //return right
        return findSmallest(node.right);
    }
}
