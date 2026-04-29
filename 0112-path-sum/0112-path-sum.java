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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)return false;
        
        return pathSum(root,targetSum,0) ;
    }

    public boolean pathSum(TreeNode root,int target,int nodeSum){
        if(root != null && root.left == null && root.right == null && target == nodeSum+root.val)return true;
        else if(root == null)return false;

        boolean left = pathSum(root.left,target,nodeSum+root.val);
        boolean right = pathSum(root.right,target,nodeSum+root.val);

        if(left || right)return true;

        return false;
    }
}