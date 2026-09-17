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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(queue.size() > 0){
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null)queue.add(node.right);

                size--;
                if(size == 0){
                    result.add(node.val);
                }
            }
        }

        return result;
    }
}