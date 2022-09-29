class Solution {
    static class Pair implements Comparable<Pair>{
        int val;
        int diff;
        public Pair(int val,int diff){
            this.val = val;
            this.diff = diff;
        }
        
        public int compareTo(Pair obj){
            return this.diff - obj.diff;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();
        
        for(int val:arr){
            int d = Math.abs(val - x);
            if(pq.size() == k){
                if(pq.peek().diff > d){
                    pq.remove();
                    pq.add(new Pair(val,d));
                }
            }
            else pq.add(new Pair(val,d));
        }
        
        while(pq.size() > 0){
            list.add(pq.remove().val);
        }
        Collections.sort(list);
        return list;
    }
}