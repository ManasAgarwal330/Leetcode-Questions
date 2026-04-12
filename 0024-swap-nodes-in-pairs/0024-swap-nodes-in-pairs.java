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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode t1 = head;
        ListNode t2 = head.next;
        ListNode prevRef = null;
        head = t2;
        while(t1 != null && t2 != null){
            ListNode next = t2.next;
            t2.next = t1;
            t1.next = null;
            if(prevRef == null){
                prevRef = t1;
            }else{
                prevRef.next = t2;
                prevRef = t1;
            }
            t1 = next;
            if(t1 != null)t2 = t1.next;
            
        }

        if(t2 == null){
            prevRef.next = t1;
        }

        return head;
    }
}