class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] ans =  dijkstra(n, times, k-1);
        Arrays.sort(ans);

        return ans[ans.length-1] == Integer.MAX_VALUE ? -1 : ans[ans.length-1];
    }

     class Pair {
    int node, dist;
    Pair(int n, int d) {
        node = n;
        dist = d;
    }
}

public int[] dijkstra(int V, int[][] edges, int src) {

    List<List<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<>());
    }

    // Build graph
    for (int[] e : edges) {
        int u = e[0]-1, v = e[1]-1, w = e[2];
        adj.get(u).add(new Pair(v, w));
    }

    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    PriorityQueue<Pair> pq =
        new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));

    pq.offer(new Pair(src, 0));

    while (!pq.isEmpty()) {
        Pair curr = pq.poll();

        // 🔥 Skip stale entries
        if (curr.dist > dist[curr.node]) continue;

        for (Pair nei : adj.get(curr.node)) {
            int newDist = curr.dist + nei.dist;

            if (newDist < dist[nei.node]) {
                dist[nei.node] = newDist;
                pq.offer(new Pair(nei.node, newDist));
            }
        }
    }

    return dist;
}
}