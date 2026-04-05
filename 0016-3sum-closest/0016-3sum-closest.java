class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums) ;// nlogn
        int i = 0;
        int ans = Integer.MAX_VALUE-10000;
        while(i < nums.length-2){
            int ans2sum = twoSum(nums,target-nums[i],i+1,nums.length-1);
            if(Math.abs(target-ans) > Math.abs(target-(nums[i]+ans2sum))){
                ans = nums[i]+ans2sum;
            }
            i++;
        }
        return ans;
    }

    public int twoSum(int[] numbers, int target , int left, int right) {
        int closestAns = Integer.MAX_VALUE-10000;
        while(left < right){
            if(Math.abs(target - closestAns) > Math.abs(target-(numbers[left]+numbers[right]))){
                closestAns = numbers[left]+numbers[right];
            }
            if((numbers[left]+numbers[right]) < target){
                left++;
            }else if((numbers[left]+numbers[right]) > target)
            {
                right--;
            }else{
                left++;
                right--;
            }
        }

        return closestAns;
    }
}