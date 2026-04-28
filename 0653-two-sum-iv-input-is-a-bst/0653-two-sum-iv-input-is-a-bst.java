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
    TreeNode p = null;
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)return false;
        if(p == null)p = root;

        // System.out.println(p.val+" "+root.val+" "+(k-root.val));
        boolean ans = search(p,root,k-root.val);
        // System.out.println(ans);
        if(ans) return true;
        boolean leftAns = findTarget(root.left,k);
        boolean rightAns = findTarget(root.right,k);

        if(leftAns || rightAns) return true;

        return false;
    }

    public boolean search(TreeNode parentRoot,TreeNode root,int target){
        if(parentRoot == null) return false;
        else if(parentRoot.val == target && root.val != target)return true;
        boolean ans = false;
        if(parentRoot.val < target){
            ans |= search(parentRoot.right,root,target);
        }else{
            ans |= search(parentRoot.left,root,target);
        }

        return ans;
    }
}