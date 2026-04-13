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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int k = 1;
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode start = temp;
            int count = k;

            System.out.println(k);
            while(count > 0 && temp != null){
                if(k%2 == 1 && count == 1){
                    prev = temp;
                    prevRef = temp;
                }
                count--;
                temp = temp.next;
            }
            
            if(k%2 == 0 && count == 0){
                System.out.println("inside");
                prev.next = reverseBetween(start,1,k);
            }else if((k-count)%2 == 0){
               prevRef.next = reverseBetween(start,1,k-count);
            }

            k++;
        }

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