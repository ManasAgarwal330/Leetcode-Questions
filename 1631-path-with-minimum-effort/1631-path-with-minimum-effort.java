class Solution {
    class Pair{
        int x,y,d;
        public Pair(int x,int y, int d)
        {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int[][] dis = new int[heights.length][heights[0].length];
        for (int i = 0; i < dis.length; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.d,b.d));
        int[][] directions =  {{0,1},{0,-1},{1,0},{-1,0}};

        pq.add(new Pair(0,0,0));
        dis[0][0] = 0;
        while(!pq.isEmpty()){
            Pair e = pq.poll();
            for(int i=0;i<directions.length;i++){
                int s = directions[i][0] + e.x;
                int d = directions[i][1] + e.y;

                if(s >= 0 && d >= 0 && s < heights.length && d < heights[0].length){
                    int newDist = Math.max(Math.abs(heights[e.x][e.y] - heights[s][d]),dis[e.x][e.y]);
                    if(dis[s][d] > newDist){
                        dis[s][d] = newDist;
                        pq.add(new Pair(s,d,newDist));
                    }
                }
            }
        }

        return dis[dis.length-1][dis[0].length-1] == Integer.MAX_VALUE ? 0 : dis[dis.length-1][dis[0].length-1];
    }
}