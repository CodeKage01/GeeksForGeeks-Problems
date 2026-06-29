class Solution {

    public int minInsAndDel(int[] a, int[] b) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < b.length; i++) {
            map.put(b[i], i);
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int num : a) {

            if (!map.containsKey(num))
                continue;

            int idx = map.get(num);

            int pos = lowerBound(lis, idx);

            if (pos == lis.size())
                lis.add(idx);
            else
                lis.set(pos, idx);
        }

        int common = lis.size();

        return (a.length - common) + (b.length - common);
    }

    private int lowerBound(ArrayList<Integer> list, int target) {

        int low = 0;
        int high = list.size();

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) >= target)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}
