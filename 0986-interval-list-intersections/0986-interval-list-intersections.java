class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();

        int first = 0;
        int second = 0;

        int pe = -1;
        while(first < firstList.length && second < secondList.length)
        {
            int fs = firstList[first][0]; 
            int fe = firstList[first][1];

            int ss =  secondList[second][0];
            int se =  secondList[second][1];

            if(pe >= fs){
                ans.add(new int[]{fs,Math.min(pe,fe)});
            }else if(pe >= ss){
                ans.add(new int[]{ss,Math.min(pe,se)});
            }

            if((fs <= ss && fe >= ss) || (fs >= ss && fe <= se) || (fs <= se && fe >= se)){
                ans.add(new int[]{Math.max(fs,ss),Math.min(fe,se)});
            }else{
                if(fs < ss){
                    first++;
                    continue;
                    // ans.add(new int[]{fs,fe});
                    // ans.add(new int[]{ss,se});
                }else if(fs > ss){
                    second++;
                    continue;
                    // ans.add(new int[]{ss,se});
                    // ans.add(new int[]{fs,fe});
                }
            }

            pe = Math.max(fe,se);

            first++;
            second++;
        }

        while(first < firstList.length){
            int fs = firstList[first][0]; 
            int fe = firstList[first][1];
            if(pe >= fs){
                ans.add(new int[]{fs,Math.min(pe,fe)});
            }
            pe = Math.max(pe,fe);

            first++;
        }


        while(second < secondList.length){
            int ss = secondList[second][0]; 
            int se = secondList[second][1];
            if(pe >= ss){
                ans.add(new int[]{ss,Math.min(pe,se)});
            }
            pe = Math.max(pe,se);

            second++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}