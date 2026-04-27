/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       LCA(root,p,q);
       return lca; 
    }

    public int LCA(TreeNode root,TreeNode p , TreeNode q){
        if(root == null)return 0;

        int ans = 0;
        if(p.val > root.val && q.val > root.val){
            ans += LCA(root.right,p,q);
        }else if( p.val < root.val && q.val < root.val){
            ans += LCA(root.left,p,q);
        }else{
            ans += LCA(root.left,p,q);
            ans += LCA(root.right,p,q);
        }

        if(root.val == p.val || root.val == q.val)ans += 1;
        if(ans == 2 && lca == null)lca = root;
        return ans;
    }
}