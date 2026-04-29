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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root,0);
        return ans;
    }

    public void traverse(TreeNode root,int num){
        if(root == null)return;
        if(root.left == null && root.right == null){
            num = num*10+root.val;
            ans += num;

            return;
        }

        traverse(root.left,num*10+root.val);
        traverse(root.right,num*10+root.val);
    }
}