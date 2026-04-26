class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;

        int nuZeroes = 0;
        int nuOnes = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)nuZeroes++;
            else nuOnes++;

            int dif = nuZeroes-nuOnes;

            if(dif == 0){
                ans = Math.max(ans, i+1);
            }
            if(map.containsKey(dif)){
                ans = Math.max(ans, i - map.get(dif));
            }else{
                map.put(dif,i);
            }
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}