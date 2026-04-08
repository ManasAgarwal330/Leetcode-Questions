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
    public boolean isPalindrome(ListNode head) {
        checker = head;
       return checkPalindrome(head);
    }

    public boolean checkPalindrome(ListNode temp){
        if(temp == null){
            return true;
        }

        boolean ans = checkPalindrome(temp.next);

        if(!ans || checker.val != temp.val){
            return false;
        }
       
        checker = checker.next;
        return ans;
    }
}