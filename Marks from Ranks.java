// Approach 1

class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int x:rank){
            int count = 0;
            
            for(int i=0;i<l.length;i++){
                int size = r[i] - l[i] + 1;
                
                if(x <= count + size){
                    int mark = l[i] + (x-count - 1);
                    res.add(mark);
                    break;
                }
                count+= size;
            }
        }
        return res;
    }
}


// **************************************************************************************


// Approach 2

class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int q = rank.length;
        
        int[][] queries = new int[q][2];
        for(int i=0;i<q;i++){
            queries[i][0] = rank[i];
            queries[i][1] = i;
        }
        
        Arrays.sort(queries, (a, b)->Integer.compare(a[0], b[0]));
        
        int[] ans = new int[q];
        
        int i = 0;
        int count = 0;
        
        for(int[] query: queries){
            int x = query[0];
            int originalIndex = query[1];
            
            while(i < l.length){
                int size = r[i] - l[i] + 1;
                if(x <= count+size){
                    int mark = l[i] + (x-count-1);
                    ans[originalIndex] = mark;
                    break;
                }
                count+=size;
                i++;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int x:ans){
            res.add(x);
        }
        return res;
    }
}
