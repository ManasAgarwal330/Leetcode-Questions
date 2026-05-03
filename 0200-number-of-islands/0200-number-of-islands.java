class Solution {
    public int numIslands(char[][] grid) {
        int island = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    island++;
                    dfs(grid,i,j);
                }
            }
        }

        return island;
    }
    int[][] directions = {
    {0, 1},   // right
    {0, -1},  // left
    {1, 0},   // down
    {-1, 0}   // up
};
    public void dfs(char[][] grid, int i,int j){
        grid[i][j] = '0';

        for(int k=0;k<directions.length;k++){
            int s = i + directions[k][0];
            int d = j + directions[k][1];

            if(s >= 0 && d >= 0 && s < grid.length && d < grid[0].length && grid[s][d] != '0'){
                dfs(grid,s,d);
            }
        }
    }
}