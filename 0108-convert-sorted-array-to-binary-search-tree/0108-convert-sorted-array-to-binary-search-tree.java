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
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums,0,nums.length-1);
    }

    public TreeNode bst(int[] nums,int lower,int upper)
    {
        if(lower > upper)return null;
        else if(lower == upper)return new TreeNode(nums[lower]); 

        int mid = (lower+upper)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = bst(nums,lower,mid-1);
        node.right = bst(nums,mid+1,upper);

        return node;
    }
}