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
    class Pair{
        TreeNode root;
        boolean containsOnes;
        public Pair(TreeNode root,boolean containsOnes){
            this.root = root;
            this.containsOnes = containsOnes;
        }
    }
    public TreeNode pruneTree(TreeNode root) {
       pruneTreeHelper(root);
        if(root.right == null && root.left == null && root.val != 1)return null;
        return root;
    }
    
    public Pair pruneTreeHelper(TreeNode root){
         if(root == null){
            Pair np = new Pair(null,false);
            return np;
        }
        
        Pair lp = pruneTreeHelper(root.left);
        Pair rp = pruneTreeHelper(root.right);
        
        if(!lp.containsOnes){
            root.left = null;
        }
        if(rp.containsOnes == false){
            root.right = null;
        }
        
        boolean ones = root.val == 1 ? true : false || lp.containsOnes || rp.containsOnes;
        
        Pair np = new Pair(root,ones);
        
        return np;
    }
}