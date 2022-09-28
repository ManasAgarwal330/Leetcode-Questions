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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)return head;
        k =0 ;
        ListNode hd = helper(head,n);
        if(hd == null){
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }
        return head;
    }
    public int k = 0;
    public ListNode helper(ListNode head,int n){
        if(head == null)return null;
        ListNode temp = helper(head.next,n);
        if(temp == null){
            head.next = head.next != null ? head.next.next : null;
        }
        else head.next = temp;
        k++;
        
        if(k == n){
            return null;
        }
        return head;
    }
}