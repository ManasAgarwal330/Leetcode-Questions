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
    TreeNode lca = null;
    int depth = Integer.MIN_VALUE;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null)return null;
        deepestLCA(root,0);
        return lca;
    }

    public int deepestLCA(TreeNode root,int dep){
        if(root == null)return dep;

        int leftDepth = deepestLCA(root.left,dep+1);
        int rightDepth = deepestLCA(root.right,dep+1);

        if(leftDepth == rightDepth){
            if(depth == Integer.MIN_VALUE){
                lca = root;
                depth = leftDepth;
                // System.out.print(lca.val+" "+depth);
            }else{
                if(leftDepth >= depth){
                    lca = root;
                    depth = leftDepth;
                    // System.out.print(lca.val+" "+depth);
                }
            }
        }
        
        return Math.max(leftDepth,rightDepth);
    }
}