class Solution {
    int index;
    
    public boolean canRepresentBST(List<Integer> arr) {
        index = 0;
        build(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return index == arr.size();
    }
    
    private void build(List<Integer> arr, int min, int max){
        if(index == arr.size()){
            return;
        }
        int val = arr.get(index);
        if(val < min || val > max){
            return;
        }
        
        index++;
        
        build(arr, min, val);
        build(arr, val, max);
    }
}
