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
    List<List<Integer>> papaAns;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        papaAns = new ArrayList<>();
        path(root,new ArrayList<Integer>(),targetSum,0);
        return papaAns;
    }

    public void path(TreeNode root,List<Integer> ans , int targetSum,int sum){
        if(root == null)return;
        if(root.left==null && root.right == null && sum+root.val == targetSum){
            ArrayList n = new ArrayList<>(ans);
            n.add(root.val);
            papaAns.add(n);
            return;
        }

        ans.add(root.val);
        path(root.left,ans,targetSum,sum+root.val);
        path(root.right,ans,targetSum,sum+root.val);
        ans.remove(ans.size()-1);
    }
}