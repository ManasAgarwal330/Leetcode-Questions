class Solution {
    public class Frequent{
        int element;
        int occurence;
        public Frequent(int element, int occurence)
        {
            this.element = element;
            this.occurence = occurence;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Frequent> maxHeap = new PriorityQueue<>((a,b) -> a.occurence - b.occurence);

        HashMap<Integer,Integer> dict = new HashMap<>();
        for(int num:nums){
            dict.put(num,dict.getOrDefault(num,0)+1);
        }
        int temp = k;
        for(Map.Entry<Integer,Integer> entry: dict.entrySet()){
            if(k > 0){
                maxHeap.add(new Frequent(entry.getKey(),entry.getValue()));
                k--;
            }else{
                if(entry.getValue() > maxHeap.peek().occurence){
                    maxHeap.poll();
                    maxHeap.add(new Frequent(entry.getKey(),entry.getValue()));
                }
            }
        }

        int[] ans = new int[temp];
        int j = 0;
        while(maxHeap.size() != 0){
            ans[j] = maxHeap.poll().element;
            j++;
        }

        return ans;
    }
}