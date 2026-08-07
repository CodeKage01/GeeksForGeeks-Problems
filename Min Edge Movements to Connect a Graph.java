class Solution {
    int minEdgesReq(int n, int[][] edges) {
        int m = edges.length;
        if(m < n-1){
            return -1;
        }
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        boolean[] visited = new boolean[n];
        int components = 0;
        int extraEdges = 0;
        
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            components++;
            int vertices = 0;
            int edgesCount = 0;
            
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;
            
            while(!q.isEmpty()){
                int node = q.poll();
                vertices++;
                edgesCount+= adj.get(node).size();
                
                for(int next:adj.get(node)){
                    if(!visited[next]){
                        visited[next] = true;
                        q.add(next);
                   }
                }
            }
            int actualEdges = edgesCount/2;
            extraEdges+= actualEdges-vertices + 1;
        }
        
        int required = components - 1;
        if(extraEdges >= required){
            return required;
        }
        return -1;
    }
}
