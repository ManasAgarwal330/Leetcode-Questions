class Solution {
    public int findDuplicate(int[] arr) {
        int slow = 0;
        int fast = 0;

        while(true){
            fast = arr[arr[fast]];
            slow = arr[slow];

            if(fast == slow){
                break;
            }
        }

        slow = 0;
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }
}