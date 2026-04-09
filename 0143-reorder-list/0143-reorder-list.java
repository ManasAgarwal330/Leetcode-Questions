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
    ListNode checker;
    public void reorderList(ListNode head) {
        if(head.next == null)return;
        checker = head;

        reorder(head);
    }

    public boolean reorder(ListNode temp){
        if(temp == null)return false;

        boolean ans = reorder(temp.next);
        if(ans){
            return true;
        }

        temp.next = null;

        if(checker.next == temp || checker == temp){
            return true;
        }
        ListNode tmp = checker.next;
        checker.next = temp;
        temp.next = tmp;
        checker = tmp;
        return false;
    }
}