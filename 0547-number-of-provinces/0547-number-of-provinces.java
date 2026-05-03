class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<Integer>[] adjMtx = new ArrayList[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            adjMtx[i] = new ArrayList<>();
        }

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j] == 1 && i != j)
                {
                    adjMtx[i].add(j);
                    adjMtx[j].add(i);
                }
            }
        }

        HashSet<Integer> visited= new HashSet<>();
        int provinces = 0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited.contains(i)){
                dfs(adjMtx,i,visited);
                provinces++;
            }
        }
        return provinces;
    }


    public void dfs(ArrayList<Integer>[] adjMtx,int src,HashSet<Integer> visited){
        visited.add(src);
        for(int i=0;i<adjMtx[src].size();i++){
            if(!visited.contains(adjMtx[src].get(i))){
                dfs(adjMtx,adjMtx[src].get(i),visited);
            }
        }
    }
}