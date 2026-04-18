class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left =0 ;
        int right = Arrays.stream(candies).max().getAsInt();
        int ans = 0;
        while(left <= right){
            int mid = (left + right)/2;
            if(isPossibleDistribution(candies,k,mid)){
                ans = Math.max(ans,mid);
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return ans;
    }

    public boolean isPossibleDistribution(int[] candies,long k,int candy){
        if(candy == 0)return true;
        for(int i=0;i<candies.length;i++){
           if(candies[i] >= candy){
              k -= candies[i]/candy;
              if(k <= 0)
                return true;
           } 
        }
        return false;
    }
}