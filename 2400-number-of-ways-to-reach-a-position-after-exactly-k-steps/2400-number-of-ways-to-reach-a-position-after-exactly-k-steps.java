class Solution {
    public Integer[][] dp;
    public int mod = (int)(1e9+7);
    public int numberOfWays(int startPos, int endPos, int k) {
        dp = new Integer[4000][1001];
        return helper(startPos,endPos,k);
    }
    
    public int helper(int startPos,int endPos,int k){
        if(startPos == endPos && k == 0){
            return 1;
        }else if(k == 0)return 0;
        
        if(dp[startPos+1000][k] != null)return dp[startPos+1000][k];
        
        int cn1 = helper(startPos + 1,endPos,k-1) % mod;
        int cn2 = helper(startPos - 1,endPos,k-1) % mod;
        
        return dp[startPos+1000][k] = (cn1 + cn2) % (mod);
    }
}