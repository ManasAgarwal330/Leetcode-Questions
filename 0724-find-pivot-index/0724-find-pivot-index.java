class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftToRight = new int[nums.length];
        int[] rightToLeft = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            leftToRight[i] = (i == 0) ? nums[i] : (leftToRight[i-1]+nums[i]);
        }

         for(int i=nums.length-1;i>=0;i--){
            rightToLeft[i] = (i == nums.length-1) ? nums[i] : (nums[i]+rightToLeft[i+1]);
        }
       

        for(int i=0;i<nums.length;i++){
            if(rightToLeft[i] == leftToRight[i])return i;
        }

        return -1;

    }
}