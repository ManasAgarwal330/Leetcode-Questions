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
    public int minDepth(TreeNode root) {
       if(root == null)return 0;
       return depth(root);
    }

    public int depth(TreeNode root){
        if(root == null)return Integer.MAX_VALUE;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if(leftDepth == Integer.MAX_VALUE && rightDepth == Integer.MAX_VALUE){
            return 1;
        }
        return Math.min(leftDepth,rightDepth)+1;
    }
}