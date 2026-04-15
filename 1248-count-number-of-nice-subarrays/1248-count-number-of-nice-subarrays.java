class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right =0;

        int numOfOdd = 0;
        int ans = 0;
        while(right < nums.length){
           if(nums[right] % 2 == 1){
                numOfOdd++;
           }

           if(numOfOdd == k){
                right++;
                while(right < nums.length){
                    if(nums[right] % 2 == 1){
                        right -= 1;
                        break;
                    }
                    right++; 
                }
                if(right == nums.length)right = right-1;
                ans += findAns(nums,left,right);
                while(left <= right){
                    if(nums[left] % 2 == 1){
                        left++;
                        numOfOdd -= 1;
                        break;
                    }
                    left++;
                }
           }

           right++;
        }

        return ans;
    }

    public int findAns(int[] nums ,int left,int right){
        int firstOddIdx = -1;
        int lastOddIdx = -1;

        for(int i = left; i <= right ; i++){
            if(nums[i] % 2 == 1){
                firstOddIdx = i;
                break;
            }
        }

        for(int i = right; i>= left ; i--){
            if(nums[i] % 2 == 1){
                lastOddIdx = i;
                break;
            }
        }

        return (1 + (firstOddIdx-left) + (right-lastOddIdx)) + ((firstOddIdx-left) * (right-lastOddIdx));
    }
}