class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[nums.length];
        int evenSum = 0;
        for(int i=0;i<nums.length;i++){
            evenSum += ((nums[i]%2) == 0 ? nums[i] : 0);
        }
        // System.out.println(evenSum);
        int i =0 ;
        for(int[] pair:queries){
            int val = pair[0];
            int idx = pair[1];
            
            if((nums[idx]+val)%2 == 0){
                if(nums[idx] % 2 == 0){
                    evenSum -= nums[idx];
                }
                nums[idx] =nums[idx]+val;
                evenSum += nums[idx];
                ans[i] = evenSum;
            }else{
                if(nums[idx] % 2 == 0){
                    evenSum -= nums[idx];
                }
                nums[idx] = nums[idx]+val;
                ans[i] = evenSum;
            }
            i++;
        }
        
        return ans;
    }
}