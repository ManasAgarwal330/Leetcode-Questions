class Solution {
    public int orangesRotting(int[][] grid) {
        int numFresh  = 0;
        Queue<Pair<Integer,Integer>> q  = new ArrayDeque();

        for(int i=0;i<grid.length;i++){
            for(int j = 0; j< grid[i].length;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }else if(grid[i][j] == 1)
                {
                    numFresh++;
                }
            }
        }
        if(numFresh == 0) return 0;
        int time = 0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                size--;
                Pair<Integer,Integer> e = q.poll();
                for(int i=0;i<directions.length;i++){
                    int s = directions[i][0] + e.getKey();
                    int d = directions[i][1] + e.getValue();

                    if(s >= 0 && d >=0 && s<grid.length && d < grid[0].length && grid[s][d] == 1){
                        grid[s][d] = 2;
                        q.add(new Pair(s,d));
                        numFresh -= 1;
                        if(numFresh == 0){
                            return time+1;
                        }
                    }
                }
            }
            time += 1;
        }

        return -1;
    }
}