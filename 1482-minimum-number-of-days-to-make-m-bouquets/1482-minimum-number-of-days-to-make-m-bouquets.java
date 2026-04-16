class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((m*k) > bloomDay.length){
            return -1;
        }

       int left = Arrays.stream(bloomDay).min().getAsInt(); 
       int right = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;
       while(left <= right){
        int mid = (left+right)/2;
        if(canMake(bloomDay,m,k,mid)){
            ans = mid;
            right = mid-1;
        }else{
            left = mid+1;
        }
       }

       return ans;
    }

    public boolean canMake(int[] bloomDay, int m, int k,int days){
        int adjacentFlowersRequired = k;
        for(int i=0;i<bloomDay.length;i++){
            // can take
            if(bloomDay[i] <= days){
                adjacentFlowersRequired--;
                if(adjacentFlowersRequired == 0){
                    m--;
                    adjacentFlowersRequired = k;
                }
            }else{
                adjacentFlowersRequired = k;
            }
        }

        return m <= 0 ? true : false;
    }
}