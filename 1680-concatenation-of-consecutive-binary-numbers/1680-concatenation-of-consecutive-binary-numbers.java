class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int mod = (int)(1e9+7);
        for(int i=1;i<=n;i++){
            int logVal =(int)((Math.log(i)/Math.log(2))+1); 
            // System.out.println(logVal);
            long left = (ans<<logVal)%mod;
            ans = (left + i)%mod; 
            // System.out.println(logVal+" "+ans);
        }
        
        return (int)ans;
    }
}