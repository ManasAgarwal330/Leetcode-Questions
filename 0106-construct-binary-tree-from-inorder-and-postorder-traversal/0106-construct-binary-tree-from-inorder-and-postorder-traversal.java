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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode head = null;
        Stack<TreeNode> stack = new Stack<>();
        for(int i=postorder.length-1;i>=0;i--){
            TreeNode node= new TreeNode(postorder[i]);
            if(head == null) head = node;
            TreeNode parent = null;
            if(!stack.isEmpty()){
               parent = stack.pop();
            }

            if(parent != null){
                int nodeIdx = map.get(node.val);
                int parentIdx = map.get(parent.val);

                if(nodeIdx > parentIdx){
                    parent.right = node;
                    stack.push(parent);
                }else{
                    if(stack.isEmpty() || nodeIdx > map.get(stack.peek().val))
                    {
                        parent.left = node;
                        // stack.push(parent);
                    }else{
                        i = i+1;
                        continue;
                    }
                }
            }
            stack.push(node);
        }

        return head;
    }
}