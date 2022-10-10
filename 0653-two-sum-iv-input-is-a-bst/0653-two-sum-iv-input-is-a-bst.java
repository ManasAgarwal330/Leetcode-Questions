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
    public boolean ans = false;
    public boolean findTarget(TreeNode root, int k) {
        ans = false;
        helper(root,root,k);
        return ans;
    }
    public void helper(TreeNode root,TreeNode rt,int k){
        if(rt == null)return;
        if(rt.val == k-rt.val){}
        else{
            boolean fnd = find(root,k - rt.val);
            if(fnd){
                ans = true;
                return;
            }
        }
        helper(root,rt.left,k);
        helper(root,rt.right,k);
    }
    public boolean find(TreeNode root,int vl){
        if(root == null)return false;
        else if(root.val == vl)return true;
        
        boolean left = false;
        boolean right = false;
        if(root.val < vl){
            left = find(root.right,vl);
        }else{
            right = find(root.left,vl);
        }
        if(left || right)return true;
        return false;
    }
}