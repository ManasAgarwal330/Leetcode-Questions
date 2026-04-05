/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        if(head.next == null){
            return head;
        } 
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        while(temp != null){
            while(!stack.empty() && stack.peek().val < temp.val)stack.pop();
            stack.push(temp);
            temp = temp.next;
        }

        ListNode prev = null;
        while(!stack.empty()){
            temp = stack.peek();
            temp.next = prev;
            prev = temp;
            stack.pop();
        }

        return prev;
    }
}