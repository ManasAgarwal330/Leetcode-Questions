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

    boolean found = false;
    TreeNode lcaNode = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root,p,q);
        return lcaNode;
    }

    public boolean lca(TreeNode root,TreeNode p,TreeNode q){
        if(root == null)return false;

        boolean left = lca(root.left,p,q);
        boolean right = lca(root.right,p,q);

        if(found){
            return false;
        }

        if(left && right)
        {
            found = true;
            lcaNode = root;
        }

        if((left && (root.val == p.val || root.val == q.val)) || (left && (root.val == p.val || root.val == q.val))){
            found = true;
            lcaNode = root;
        }

        if((right && (root.val == p.val || root.val == q.val)) || (right && (root.val == p.val || root.val == q.val))){
            found = true;
            lcaNode = root;
        }

        if(root.val == p.val || root.val == q.val)return true;

        return (left || right);

    }
}