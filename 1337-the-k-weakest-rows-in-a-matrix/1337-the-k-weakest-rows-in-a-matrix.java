class Solution {
    public class WeakestRows{
        int soldiers;
        int pos;
        public WeakestRows(int soldiers,int pos){
            this.soldiers = soldiers;
            this.pos = pos;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<WeakestRows> maxHeap = new PriorityQueue<>((a,b) -> {
            if(a.soldiers == b.soldiers){
                return Integer.compare(b.pos,a.pos);
            }else{
                return Integer.compare(b.soldiers,a.soldiers);
            }
        });

        int i = 0;
        while(k > 0){
            int soldiersCount = (int)Arrays.stream(mat[i]).filter(x -> x == 1).count();
            maxHeap.add(new WeakestRows(soldiersCount,i));
            k--;
            i++;
        }

        while(i < mat.length){
            int soldiersCount = (int)Arrays.stream(mat[i]).filter(x -> x == 1).count();
            if(soldiersCount < maxHeap.peek().soldiers){
                maxHeap.poll();
                maxHeap.add(new WeakestRows(soldiersCount,i));
            }
            i++;
        }

        int[] ans = new int[maxHeap.size()];
        int j = maxHeap.size()-1;
        while(maxHeap.size() != 0)
        {
            ans[j] = maxHeap.poll().pos;
            j--;
        }

        return ans;

    }
}