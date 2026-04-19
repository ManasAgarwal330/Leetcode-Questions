class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i  = 0;
        while(k > 0){
            pq.add(nums[i]);
            k--;
            i++;
        }

        while(i < nums.length){
            if(pq.peek() < nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }

            i++;
        }

        return pq.peek();
    }
}