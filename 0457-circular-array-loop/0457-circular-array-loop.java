class Solution {
    public boolean circularArrayLoop(int[] nums) {

        for(int i = 0; i< nums.length; i++){
            int slow = i;
            int fast = i;

            boolean isPositive = nums[slow] > 0 ? true : false;

            while(isPositive && nums[slow] > 0 && nums[fast] > 0){
                fast = (fast + (nums[fast]%nums.length))%nums.length;
                if(nums[fast] < 0)break;
                fast = (fast + (nums[fast]%nums.length))%nums.length;
                slow = (slow + (nums[slow]%nums.length))%nums.length;
                
                if(slow == fast){
                    int prevSlow = slow;
                    slow = (slow + (nums[slow]%nums.length))%nums.length;
                    if(prevSlow == slow){
                        break;
                    }
                    return true;
                }
            }
            
            while(!isPositive && nums[slow] < 0 && nums[fast] < 0)
            {
                int val = (fast -(Math.abs(nums[fast])%nums.length));
                fast = val >= 0 ? val : (nums.length+val);
                if(nums[fast] > 0)break;
                val = (fast - (Math.abs(nums[fast])%nums.length));
                fast = val >= 0 ? val : (nums.length+val);

                val = (slow - (Math.abs(nums[slow])%nums.length));
                slow = val >= 0 ? val : (nums.length+val);
                
                if(slow == fast){
                    int prevSlow = slow;
                    val = (slow - (Math.abs(nums[slow])%nums.length));
                    slow = val >= 0 ? val : (nums.length+val);
                    if(prevSlow == slow){
                        break;
                    }
                    return true;
                }
            }
        }

        return false;
    
    }
}