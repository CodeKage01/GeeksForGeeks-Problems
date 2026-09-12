class Solution {
    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        
        if(n == 1){
            return 0;
        }
        
        // step 1: Find one end of the diameter
        int[] first = bfs(adj, 1);
        int farthestNode = first[0];
        
        // step 2: Find the diameter length
        int[] second = bfs(adj, farthestNode);
        int diameter = second[1];
        
        return (diameter + 1)/2;
        
    }
    
    private int[] bfs(ArrayList<ArrayList<Integer>> adj, int start){
        int n = adj.size();
        
        int[] dist = new int[n+1];
        
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        dist[start] = 0;
        
        int farthestNode = start;
        int farthestDistance = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int next: adj.get(node-1)){
                if(dist[next] == -1){
                    dist[next] = 1 + dist[node];
                    q.offer(next);
                    
                    if(dist[next] > farthestDistance){
                        farthestDistance = dist[next];
                        farthestNode = next;
                    }
                }
            }
        }
        return new int[]{farthestNode, farthestDistance};
    }
}
