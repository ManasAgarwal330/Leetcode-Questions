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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null)return 0;
        maxSum(root);
        return ans;
    }

    public int maxSum(TreeNode root){
        if(root == null)return 0;

        int leftSum =  maxSum(root.left);
        int rightSum = maxSum(root.right);
        int includeSumLeft = leftSum + root.val ;
        int includeSumRight = rightSum + root.val ;
        int includeSum = leftSum + rightSum + root.val;
        ans = Math.max(includeSumLeft,Math.max(includeSumRight,Math.max(root.val,Math.max(ans,includeSum))));

        return Math.max(root.val,Math.max(includeSumLeft,includeSumRight));
    }   
}