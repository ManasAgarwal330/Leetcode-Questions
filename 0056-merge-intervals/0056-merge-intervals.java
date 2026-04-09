class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> ans = new ArrayList<>();
        int ps = intervals[0][0];
        int pe = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            int ss = intervals[i][0];
            int se = intervals[i][1];

            if(pe >= ss){
                pe = Math.max(pe,se);
            }
            else
            {   
                ans.add(new int[]{ps, pe});
                ps = ss;
                pe = se;
            }
        }
        ans.add(new int[]{ps, pe});
        return ans.toArray(new int[ans.size()][]);
        
    }
}