class Solution {
    public boolean increasingTriplet(int[] nums) {
        int mx1 = Integer.MAX_VALUE;
        int mx2 = Integer.MAX_VALUE;
        
        for(int n:nums){
            if(n <= mx1){
                mx1 = n;
            }else if(n <= mx2)mx2 = n;
            else return true;
        }
        
        return false;
    }
}