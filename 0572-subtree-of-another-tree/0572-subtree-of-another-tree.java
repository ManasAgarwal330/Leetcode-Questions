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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)return true;
        else if((root == null && subRoot != null) || (root != null && subRoot == null))return false;
        boolean leftD = isSubtree(root.left,subRoot);
        boolean rightD = isSubtree(root.right,subRoot);

        if(leftD || rightD){
            return true;
        }

        if(root.val == subRoot.val){
            return checkIfSameStructure(root,subRoot);
        }

        return false;
    }


    public boolean checkIfSameStructure(TreeNode root,TreeNode subRoot){
         if(root == null && subRoot == null)return true;
        else if((root == null && subRoot != null) || (root != null && subRoot == null))return false;

        boolean leftD = checkIfSameStructure(root.left,subRoot.left);
        boolean rightD = checkIfSameStructure(root.right,subRoot.right);

        if(!leftD || !rightD)return false;

        if(root.val != subRoot.val)return false;

        return true;
    }
}