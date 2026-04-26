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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)return new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        boolean isLeftToRight = true;
        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> i = new ArrayList<>();
            while(size > 0){
                TreeNode e = queue.poll();
                if(e.left != null) queue.offer(e.left);
                if(e.right != null) queue.offer(e.right);
                size--;
                if(isLeftToRight)
                    i.add(e.val);
                else
                    i.addFirst(e.val);
            }
            isLeftToRight = !isLeftToRight;
            ans.add(i);
        }

        return ans;
    }
}