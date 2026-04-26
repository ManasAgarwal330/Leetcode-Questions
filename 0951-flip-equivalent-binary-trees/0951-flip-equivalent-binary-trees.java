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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)return true;
        else if((root1 == null && root2 != null) || (root1 != null && root2 == null))return false;
        if(root1.val != root2.val)return false;

        boolean ans = true;
        int root1Child = root1.left!= null && root1.right != null ? 2 : (root1.left == null && root1.right == null) ? 0 : 1;
        int root2Child = root2.left!= null && root2.right != null ? 2 : (root2.left == null && root2.right == null) ? 0 : 1;

        if(root1Child != root2Child)return false;
        if(root1.left != null){
            if(root2.left != null && root2.left.val == root1.left.val){
                ans &= flipEquiv(root1.left,root2.left);
            }else if(root2.right != null && root2.right.val == root1.left.val){
                ans &= flipEquiv(root1.left,root2.right);
            }else return false;
        }

        if(root1.right != null){
            if(root2.left != null && root2.left.val == root1.right.val){
                ans &= flipEquiv(root1.right,root2.left);
            }else if(root2.right != null && root2.right.val == root1.right.val){
                ans &= flipEquiv(root1.right,root2.right);
            }else return false;
        }

        if(!ans)return false;

        return true;
    }
}