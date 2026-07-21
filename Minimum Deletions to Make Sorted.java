class Solution {
    public int minDeletions(int[] arr) {
        ArrayList<Integer> tails = new ArrayList<>();
        
        for(int num:arr){
            int index = binarySearch(tails, num);
            if(index == tails.size()){
                tails.add(num);
            }else{
                tails.set(index, num);
            }
        }
        return arr.length - tails.size();
    }
    
    private int binarySearch(ArrayList<Integer> list, int target){
        int low = 0, high = list.size()-1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(list.get(mid) >= target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
