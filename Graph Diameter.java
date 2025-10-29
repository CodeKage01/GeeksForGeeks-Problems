class Solution {
    public int diameter(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e: edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int farthestNode = bfs(0, graph, V)[0];
        
        int[] res = bfs(farthestNode, graph, V);
        
        return res[1];
        
    }
    
    private int[] bfs(int start, List<List<Integer>> graph, int V){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        
        q.add(start);
        visited[start] = true;
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int nei: graph.get(node)){
                if(!visited[nei]){
                    visited[nei] = true;
                    dist[nei] = dist[node] + 1;
                    q.add(nei);
                }
            }
        }
        int maxDist = 0, farNode = start;
        for(int i=0;i<V;i++){
            if(dist[i] > maxDist){
                maxDist = dist[i];
                farNode = i;
            }
        }
        
        return new int[]{farNode, maxDist};
        
    }
}
