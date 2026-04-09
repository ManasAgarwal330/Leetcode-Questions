class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        for(int i =0 ; i< intervals.length;i++){
            ans.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        ans.add(new int[]{newInterval[0],newInterval[1]});

        intervals = ans.toArray(new int[ans.size()][]);
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        ans = new ArrayList<>();
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