class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long left = 1;
        long right = Arrays.stream(piles).max().getAsInt();;
        long ans = Integer.MAX_VALUE;
        while(left <= right){
            long mid = (left+right)/2;
            if(canKokoEat(piles,h,mid)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return (int)ans;
    }

    public boolean canKokoEat(int[] piles,int h, long speed){
        long totalTimeRequired = 0;
        for(int i=0;i<piles.length;i++){
            totalTimeRequired += (piles[i]%speed == 0) ? (piles[i]/speed) : (piles[i]/speed)+1;
        }

        return totalTimeRequired > h ? false : true;
    }

}