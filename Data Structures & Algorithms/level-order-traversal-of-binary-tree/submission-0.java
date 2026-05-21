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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ret = new ArrayList<>();

        if(root == null) return ret;
        queue.add(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            List<Integer> group = new ArrayList<>();
            for(int i = 0; i < length; i++){
                TreeNode node = queue.removeLast();
                group.add(node.val);
                if(node.left != null) queue.addFirst(node.left);
                if(node.right != null) queue.addFirst(node.right);
            }
            ret.add(group);
        }
        return ret;
    }
}
