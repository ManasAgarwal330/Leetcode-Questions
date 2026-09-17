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
    
    boolean isBst = true;
    public boolean isValidBST(TreeNode root) {
        bst(root);

        return isBst;
    } 

    public long[] bst(TreeNode root){
        if(root == null)return new long[]{Long.MAX_VALUE,Long.MIN_VALUE};

        long[] left = bst(root.left);
        long[] right = bst(root.right);

        long smallestForNode = Math.min(Math.min(left[0],right[0]),root.val);
        long largestForNode = Math.max(Math.max(left[1],right[1]),root.val);

        if(left[1] >= root.val){
            isBst = false;
        }

        if(right[0] <= root.val){
            isBst = false;
        }

        return new long[]{smallestForNode,largestForNode};
    }
}