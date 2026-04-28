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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        depth(root);
        return balanced;
    }

     public int depth(TreeNode root){
        if(root == null)return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if(leftDepth != rightDepth+1 && leftDepth+1 != rightDepth && leftDepth != rightDepth){
            balanced = false;
        }
        return Math.max(leftDepth,rightDepth)+1;
    }
}