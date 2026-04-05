class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            List<List<Integer>> threeSumAns = threeSum(nums,(long)(target-(nums[i])),i+1,nums.length-1);
            // System.out.println(threeSumAns);
            for(List<Integer> list: threeSumAns){
                List<Integer> temp = new ArrayList<>(list);
                temp.add(0,nums[i]);
                ans.add(temp);
            }
        }

        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums,long target,int left,int right) {
        int i = left;
        List<List<Integer>> ans = new ArrayList<>();
        while(i <= right-2){
            if(i!= left && nums[i] == nums[i-1]){
                i++;
                continue;
            }
            List<List<Integer>> ans2Sum = twoSum(nums,(long)(target-(nums[i])),i+1,right);
            // System.out.println("2Sum");
            // System.out.println(ans2Sum);
            // System.out.println("over");
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

    public List<List<Integer>> twoSum(int[] numbers, long target , int left, int right) {
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