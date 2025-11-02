class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        int[] indegree = new int[V];
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int nei:adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0) q.add(nei);
            }
        }
        
        boolean[][] hasEdge = new boolean[V][V];
        for(int[] e:edges){
            hasEdge[e[0]][e[1]] = true;
        }
        
        int count = 0;
        for(int i=0;i<V;i++){
            for(int j=i+1;j<V;j++){
                int u = topo.get(i);
                int v = topo.get(j);
                if(!hasEdge[u][v]){
                    count++;
                }
            }
        }
        
        return count;
    }
}
