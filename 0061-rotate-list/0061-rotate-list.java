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
    ListNode prevRef = null;
    public ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        k = count == 0 ? 0 : k % count;
        if(head == null || head.next == null || k== 0) return head;
        head = reverseBetween(head,1,count-k);
        reverseBetween(head,count-k+1,count);
        head = reverseBetween(head,1,count);

        return head;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int pos = 1;
        ListNode temp = head;

        if(left == 1){
            return reverse(head,right-left+1);
        }


        while(pos < left-1){
            pos++;
            temp = temp.next;
        }

        temp.next = reverse(temp.next,right-left+1);
        return head;

    }

    public ListNode reverse(ListNode head, int movement){
        ListNode next = null;
        ListNode prev = null;
        ListNode temp = head;
        int pos = 1;

        while(pos <= movement){
            next = head.next;
            head.next =prev;
            prev = head;
            head = next;

            pos++;
        }

        temp.next = next;
        prevRef = temp;
        return prev;
    }
}