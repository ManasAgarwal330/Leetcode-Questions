class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        int ans = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right)/2;
            if(isPossibleDistribution(weights,days,mid)){
                ans = Math.min(ans,mid);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return ans;
    }

    public boolean isPossibleDistribution(int[] weights,int days,int leastWeight){
        int weightCap = leastWeight;
        for(int i=0;i<weights.length;i++){
           if(weightCap-weights[i] >= 0){
               weightCap -= weights[i];
           }else{
                days--;
                if(days == 0)return false;
                weightCap = leastWeight;
                weightCap -= weights[i];
           }
        }
        return true;
    }
}