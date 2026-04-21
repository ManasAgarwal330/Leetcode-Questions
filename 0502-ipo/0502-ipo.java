class Solution {
    public class IPO{
        int profit;
        int investment;
        public IPO(int profit,int investment){
            this.profit = profit;
            this.investment = investment;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<IPO> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.profit,a.profit));
        int i = 0;
        while(i < profits.length){
            maxHeap.add(new IPO(profits[i],capital[i]));
            i++;
        }

        Queue<IPO> rem = new LinkedList<>();
        while(!maxHeap.isEmpty() && k > 0){
            IPO ipo = maxHeap.poll();
            if(ipo.investment <= w){
                w += ipo.profit;
                k--;
                while(!rem.isEmpty()){
                    maxHeap.add(rem.poll());
                }
            }else{
                rem.add(ipo);
            }
        }

        return w;
    }
}