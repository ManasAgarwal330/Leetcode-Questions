class Solution {
    public class Pair{
        long sum;
        int idx;
        public Pair(long sum,int idx){
            this.sum = sum;
            this.idx = idx;
        }
    }
    public int shortestSubarray(int[] nums, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)-> Long.compare(a.sum,b.sum));
        long sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum >= k)ans = Math.min(ans,i+1);

            while(!minHeap.isEmpty() && sum - minHeap.peek().sum >= k){
                Pair p = minHeap.poll();
                ans = Math.min(ans,i-p.idx);
            }

            minHeap.add(new Pair(sum,i));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}