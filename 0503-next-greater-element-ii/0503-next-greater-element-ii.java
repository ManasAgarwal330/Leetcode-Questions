class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 1){
            return new int[]{-1};
        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        for(int i = nums.length-2; i>=0;i--){
            stack.push(nums[i]);
        }

        int i = nums.length-1;
        while(i >= 0){
            int num = nums[i];
            while(!stack.empty() && stack.peek() <= num)stack.pop();
            
            if(stack.empty()){
                ans[i] = -1;
            }
            else ans[i] = stack.peek();
            i--;
            stack.push(num);
        }

        return ans;
    }
}