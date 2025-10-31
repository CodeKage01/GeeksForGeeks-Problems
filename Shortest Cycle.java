class Solution {
    public int shortCycle(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] e:edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int start=0;start<V;start++){
            int[] dist = new int[V];
            Arrays.fill(dist, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            dist[start] = 0;
            
            while(!q.isEmpty()){
                int node = q.poll();
                for(int nei:graph.get(node)){
                    if(dist[nei] == -1){
                        dist[nei] = dist[node]+1;
                        q.add(nei);
                    }else if(dist[nei] >= dist[node]){
                        ans = Math.min(ans, dist[node]+dist[nei]+1);
                    }
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
}
