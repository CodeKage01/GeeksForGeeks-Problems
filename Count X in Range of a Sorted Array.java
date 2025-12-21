class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int[] q:queries){
            int l = q[0];
            int r = q[1];
            int x = q[2];
            
            int first = firstOccurence(arr, x);
            int last = lastOccurence(arr, x);
            
            if(first == -1 || last == -1){
                res.add(0);
                continue;
            }
            
            int start = Math.max(first, l);
            int end = Math.min(last, r);
            
            if(start > end){
                res.add(0);
            }else{
                res.add(end-start+1);
            }
        }
        return res;
    }
    
    private int firstOccurence(int[] arr, int x){
        int low = 0, high = arr.length-1;
        int ans = -1;
        
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == x){
                ans = mid;
                high = mid-1;
            }else if(arr[mid] < x){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    
    private int lastOccurence(int[] arr, int x){
        int low = 0,high=arr.length-1;
        int ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == x){
                ans = mid;
                low = mid+1;
            }else if(arr[mid] < x){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}
