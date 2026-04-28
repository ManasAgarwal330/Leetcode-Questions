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
    int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        depth(root);
        return diameter;
    }

    public int depth(TreeNode root){
        if(root == null)return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        
        diameter = Math.max(leftDepth+rightDepth,diameter);
        return Math.max(leftDepth,rightDepth)+1;
    }

    
}