class Solution {
    static int findPerimeter(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int perimeter = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // only cell with value 1 will contribute
                if(mat[i][j] == 1){
                    perimeter+= 4;
                    
                    // check upper neighbour
                    if(i > 0 && mat[i-1][j] == 1){
                        perimeter--;
                    }
                    // check lowe neighbour
                    if(i < n-1 && mat[i+1][j] == 1){
                        perimeter--;
                    }
                    // check left neighbour
                    if(j > 0 && mat[i][j-1] == 1){
                        perimeter--;
                    }
                    // check right neighbour
                    if(j < m-1 && mat[i][j+1] == 1){
                        perimeter--;
                    }
                }
            }
        }
        return perimeter;
    }
}
