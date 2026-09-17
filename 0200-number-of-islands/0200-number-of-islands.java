class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                char ch = grid[i][j];
                if(ch == '1'){
                    islandCount+=1;
                    dfs(grid,i,j);
                }
            }
        }

        return islandCount;
    }


    int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(char[][] grid,int i,int j){

            grid[i][j] = '0';
            for(int[] direction: directions){
                int new_i = i + direction[0];
                int new_j = j+direction[1];

                if(new_i >=0 && new_i < grid.length && new_j >= 0 && new_j < grid[0].length && grid[new_i][new_j] != '0'){
                    dfs(grid,new_i,new_j);
                }
            }
    }
}