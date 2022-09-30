class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<buildings.length;i++){
            int st = buildings[i][0];
            int end = buildings[i][1];
            int ht = buildings[i][2];
            
            list.add(new Pair(st,-ht));
            list.add(new Pair(end,ht));
        }
        
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int cht = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            int pnt = list.get(i).x;
            int ht = list.get(i).ht;
            
            if(ht < 0){
                pq.add(-ht);
                if(cht != pq.peek()){
                    cht = pq.peek();
                    ans.add(Arrays.asList(pnt,cht));
                }
            }else{
                pq.remove(ht);
                if(cht != pq.peek()){
                    cht = pq.peek();
                    ans.add(Arrays.asList(pnt,cht));
                }
            }
        }
        return ans;
    }
    
    class Pair implements Comparable<Pair>{
        int x;
        int ht;
        Pair(int x,int ht){
            this.x =x;
            this.ht = ht;
        }
        
        public int compareTo(Pair obj){
            if(this.x != obj.x){
                return this.x-obj.x;
            }
            return this.ht - obj.ht;

        }
    }
}