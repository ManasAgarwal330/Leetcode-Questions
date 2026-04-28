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
    public int maxDepth(TreeNode root) {
        if(root == null)return 0 ;
        return depth(root);
    }

     public int depth(TreeNode root){
        if(root == null)return Integer.MIN_VALUE;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if(leftDepth == Integer.MIN_VALUE && rightDepth == Integer.MIN_VALUE){
            return 1;
        }
        return Math.max(leftDepth,rightDepth)+1;
    }
}