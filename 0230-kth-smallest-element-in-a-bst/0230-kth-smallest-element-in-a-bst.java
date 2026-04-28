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
    int element = Integer.MIN_VALUE;
    int n ;
    public int kthSmallest(TreeNode root, int k) {
        n = k;
        inorderTraversal(root);

        return element;
    }

    public void inorderTraversal(TreeNode root){
        if(root == null)return;
        inorderTraversal(root.left);
        n = n-1;
        if(n == 0)element = root.val;
        inorderTraversal(root.right);
    }
}