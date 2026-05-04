class Solution {
    class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y; // simple hash
    }
}
    public void solve(char[][] board) {
        
        HashSet<Pair> visited = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1){
                    if(!visited.contains(new Pair(i,j)) && board[i][j] == 'O')
                        dfs(board,i,j,visited);
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!visited.contains(new Pair(i,j))){
                    board[i][j] = 'X';
                }
            }
        }
    }
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(char[][] board,int i,int j,HashSet<Pair> visited){
        visited.add(new Pair(i,j));
        for(int k=0;k<directions.length;k++){
            int s = directions[k][0] + i;
            int d = directions[k][1] + j;

            if(s >= 0 && d>= 0 && s < board.length && d < board[0].length && board[s][d] == 'O'){
                if(!visited.contains(new Pair(s,d)))
                    dfs(board,s,d,visited);
            }
        }
    }
}