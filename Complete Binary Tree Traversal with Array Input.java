class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int index = 0;
        int levelSize = 1;
        
        while(index < arr.length){
            ArrayList<Integer> cur = new ArrayList<>();
            for(int i=0;i<levelSize && index<arr.length;i++){
                cur.add(arr[index]);
                index++;
            }
            Collections.sort(cur);
            ans.add(cur);
            
            levelSize*= 2;
        }
        return ans;
    }
}
