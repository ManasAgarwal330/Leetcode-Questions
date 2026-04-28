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
    class MinMax{
        long min;
        long max;
        public MinMax(long min,long max){
            this.min = min;
            this.max = max;
        }
    }
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        valid(root);
        return isValid;
    }

    public MinMax valid(TreeNode root){
        if(root == null)return new MinMax(Long.MAX_VALUE,Long.MIN_VALUE);

        MinMax left = valid(root.left);
        MinMax right = valid(root.right);

        if(left.max < root.val && root.val < right.min){

        }else{
            isValid = false;
        }

        return new MinMax(Math.min(left.min,root.val),Math.max(right.max,root.val));
    }
}