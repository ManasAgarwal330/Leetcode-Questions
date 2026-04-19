class Solution {
    public class Distance{
        double distance;
        int index;
        public Distance(double distance,int index){
            this.distance = distance;
            this.index = index;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Distance> maxHeap = new PriorityQueue<Distance>((a,b) -> Double.compare(b.distance,a.distance));
        int i = 0;
        int temp = k;
        while(k > 0){
            double distance = Math.sqrt((points[i][0] * points[i][0]) + (points[i][1] * points[i][1]));
            maxHeap.add(new Distance(distance,i));
            k--;
            i++;
        }

        while(i < points.length){
            double distance = Math.sqrt((points[i][0] * points[i][0]) + (points[i][1] * points[i][1]));
            if(maxHeap.peek().distance > distance){
                maxHeap.poll();
                maxHeap.add(new Distance(distance,i));
            }

            i++;
        }

        int[][] ans = new int[maxHeap.size()][2];
        i = 0;
        while(maxHeap.size() != 0){
            int idx = maxHeap.poll().index;
            int x1 = points[idx][0];
            int x2 = points[idx][1];

            ans[i][0] = x1;
            ans[i][1] = x2;
            i++;
        }

        return ans;
    }
}