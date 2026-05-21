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
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> rightView = new ArrayList<>();

        if(root == null) return rightView;
        queue.addFirst(root);
        while(!queue.isEmpty()){
            TreeNode node;
            int length = queue.size();
            for(int i = 0; i < length-1; i++){
                node = queue.removeLast();
                if(node.left != null) queue.addFirst(node.left);
                if(node.right != null) queue.addFirst(node.right);
            }
            //last node
            node = queue.removeLast();
            rightView.add(node.val);
            if(node.left != null) queue.addFirst(node.left);
            if(node.right != null) queue.addFirst(node.right);
        }
        return rightView;
    }
}
