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
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        nodeSearch(root,p,q);
        return ans;
    }

    private boolean[] nodeSearch(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return new boolean[2];
        boolean[] left = nodeSearch(root.left,p,q);
        boolean[] right = nodeSearch(root.right,p,q);
        if(ans != null) return new boolean[2];
        boolean[] node = new boolean[]{(left[0] || right[0]),(left[1] || right[1])};
        if(root.val == p.val) node[0] = true;
        if(root.val == q.val) node[1] = true;
        if(node[0] && node[1]) {
            ans = root;
            System.out.println(ans.val);
        }
        return node;
    }
}
