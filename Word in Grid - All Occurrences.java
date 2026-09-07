class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                
                if(mat[r][c] != word.charAt(0)){
                    continue;
                }
                
                for(int d=0;d<8;d++){
                    int drVal = dr[d];
                    int dcVal = dc[d];
                    
                    boolean found = true;
                    
                    for(int k=0;k<word.length();k++){
                        int nr = r + k*drVal;
                        int nc = c + k*dcVal;
                        
                        if(nr < 0 || nr >= n || nc < 0 || nc >= m){
                            found = false;
                            break;
                        }
                        
                        if(mat[nr][nc] != word.charAt(k)){
                            found = false;
                            break;
                        }
                    }
                    if(found){
                        ArrayList<Integer> pos = new ArrayList<>();
                        pos.add(r);
                        pos.add(c);
                        
                        ans.add(pos);
                        break;
                    }
                }
            }
        }
        return ans;
    }
};
