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
        if(root == null)return null;
        findLowestCommonAncestor(root,p,q);
        return lca;

    }

    public int findLowestCommonAncestor(TreeNode root, TreeNode p,TreeNode q){
        if(root == null)return 0;

        int left = findLowestCommonAncestor(root.left,p,q);
        int right = findLowestCommonAncestor(root.right,p,q);

        int ans = left+right;
       if(root.val == p.val || root.val == q.val){
            ans += 1;
        }

        if(ans == 2 && lca == null){
            lca = root;
        }

        return ans;
        
    }
}