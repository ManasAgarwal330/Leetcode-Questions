class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums) ;// nlogn
        int i = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while(i < nums.length-2){
            if(i!= 0 && nums[i] == nums[i-1]){
                i++;
                continue;
            }
            List<List<Integer>> ans2Sum = twoSum(nums,-(nums[i]),i+1,nums.length-1);
            if(ans2Sum.size() > 0){
                for(List<Integer> list: ans2Sum)
                {   
                    List<Integer> temp = new ArrayList<>(list); // ✅ make mutable copy
                    temp.add(0,nums[i]);
                    ans.add(temp);
                }
            }
            i++;
        }

        return ans;
    }

    public List<List<Integer>> twoSum(int[] numbers, int target , int left, int right) {
        List<List<Integer>> ans = new ArrayList<>();
        while(left < right){
            if((numbers[left]+numbers[right]) < target){
                left++;
            }else if((numbers[left]+numbers[right]) > target)
            {
                right--;
            }else{
                ans.add(Arrays.asList(numbers[left],numbers[right]));
                left++;
                right--;
                while(left < numbers.length && numbers[left] == numbers[left-1]){
                    left++;
                }
                while(right >= 0 && numbers[right] == numbers[right+1])
                {
                    right--;
                }
            }
        }

        return ans;
    }
}