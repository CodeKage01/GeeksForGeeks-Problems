class Solution {
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<V+edges.length;i++){
            graph.add(new ArrayList<>());
        }
        
        int newNode = V;
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            if(w == 1){
                graph.get(u).add(v);
                 graph.get(v).add(u);
            }else{
                graph.get(u).add(newNode);
                graph.get(newNode).add(u);
                
                graph.get(newNode).add(v);
                graph.get(v).add(newNode);
                
                newNode++;
            }
        }
        
        boolean[] visited = new boolean[newNode];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int node = q.poll();
                if(node == dest){
                    return level;
                }
                for(int next:graph.get(node)){
                    if(visited[next]){
                        continue;
                    }
                    visited[next] = true;
                    q.offer(next);
                }
            }
            level++;
        }
        return -1;
    }
}
