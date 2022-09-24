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
    List<List<Integer>> arr; 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        arr = new ArrayList<>();
        helper(root,0,targetSum,new ArrayList<Integer>());
        return arr;
    }
    public void helper(TreeNode root,int sum,int target,ArrayList<Integer> ar){
        if(root != null && root.left == null && root.right == null && sum+root.val == target){
            ArrayList<Integer> ar2 = (ArrayList)ar.clone();
            ar2.add(root.val);
            arr.add(ar2);
            return;
        }else if(root == null)return;
        ar.add(root.val);
        helper(root.left,sum+root.val,target,ar);
        helper(root.right,sum+root.val,target,ar);
        ar.remove(ar.size()-1);
    }
}