class Solution {
    boolean isNotBipartite = false;
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adjMtx = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adjMtx.add(new ArrayList<>());
        }

        for(int i=0;i<graph.length;i++){
           for(int j=0;j<graph[i].length;j++){
                adjMtx.get(i).add(graph[i][j]);
                adjMtx.get(graph[i][j]).add(i);
           }
        }

        int[] colors = new int[graph.length];
        Arrays.fill(colors,-1);
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0;i<graph.length;i++){
            if(!visited.contains(i)){
                colors[i] = 0;
                dfs(adjMtx,i,colors,visited);
            }
        }

        return !isNotBipartite;
    }

    public void dfs(List<List<Integer>> adjMtx,int src,int[] colors,HashSet<Integer> visited){
        visited.add(src);
        List<Integer> s = adjMtx.get(src);
        for(int i=0;i < s.size() ; i++){
            if(colors[s.get(i)] == colors[src]){
                isNotBipartite = true;
                return;
            }
            if(!visited.contains(s.get(i))){
                colors[s.get(i)] = 1 - colors[src];
                dfs(adjMtx,s.get(i),colors,visited);
            }
        }
    }
}