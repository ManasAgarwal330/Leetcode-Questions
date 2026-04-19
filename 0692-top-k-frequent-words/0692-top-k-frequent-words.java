class Solution {
     public class Frequent{
        String element;
        int occurence;
        public Frequent(String element, int occurence)
        {
            this.element = element;
            this.occurence = occurence;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Frequent> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (b.occurence != a.occurence) {
                    return Integer.compare(a.occurence,b.occurence); // max heap
                }
                return b.element.compareTo(a.element); // lexicographically smaller first
            }
        );

        HashMap<String,Integer> dict = new HashMap<>();
        for(String num:words){
            dict.put(num,dict.getOrDefault(num,0)+1);
        }
        int temp = k;
        for(Map.Entry<String,Integer> entry: dict.entrySet()){
            if(k > 0){
                maxHeap.add(new Frequent(entry.getKey(),entry.getValue()));
                k--;
            }else{
                if(entry.getValue() > maxHeap.peek().occurence){
                    maxHeap.poll();
                    maxHeap.add(new Frequent(entry.getKey(),entry.getValue()));
                }else if(entry.getValue() == maxHeap.peek().occurence){
                    maxHeap.add(new Frequent(entry.getKey(),entry.getValue()));
                }
            }
        }

        List<String> ans = new ArrayList<>();
        while(maxHeap.size() != 0){
            ans.add(0,maxHeap.poll().element);
        }

        return ans.stream()
        .limit(temp)
        .map(f -> f)
        .toList();
    }
}