class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(neededTime[0]);
        for(int i=1;i<colors.length();i++){
            char cc = colors.charAt(i);
            char pc = colors.charAt(i-1);
            
            if(cc == pc){
                pq.add(neededTime[i]);
            }else{
                if(pq.size() > 1){
                    while(pq.size() > 1){
                        ans += pq.remove();
                    }
                }
                pq.remove();
                pq.add(neededTime[i]);
            }
        }
        
        while(pq.size() > 1){
            ans += pq.remove();
        }
        return ans;
    }
}