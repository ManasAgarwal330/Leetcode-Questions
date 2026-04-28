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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
         int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isLastLevel = true;
            int nodeShouldPresent = (int)Math.pow(2,level);
            boolean nullDetected = false;
            while(size > 0){
                TreeNode elem = queue.poll();
                if(elem.left != null || elem.right != null){
                    if(nullDetected)return false;
                    isLastLevel = false;
                }
                
                nodeShouldPresent--;
                if((elem.left == null && elem.right != null)) return false;
                else{
                    if(elem.left!= null)queue.add(elem.left);
                    else nullDetected = true;
                    if(elem.right != null)queue.add(elem.right);
                    else nullDetected = true;
                }
                size--;
            }

            if(!isLastLevel && nodeShouldPresent > 0)return false;
            level++;
        }

        return true;
    }
}