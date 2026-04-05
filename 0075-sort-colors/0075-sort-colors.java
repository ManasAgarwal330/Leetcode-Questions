class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = nums.length-1;
        
        while(two >= 0 && nums[two] == 2){
            two--;
        }

        while(one <= two){
            if(nums[zero] == 1){
                swap(nums,zero,one);
                one++;
            }else if(nums[zero] == 0){
                zero++;
                if(zero > one){
                    one = zero+1;
                }
            }else if(nums[zero] == 2){
                swap(nums,zero,two);
                two--;
            }

            while(two >= 0 && nums[two] == 2){
                two--;
            }

        }
    }

    public void swap(int[] nums,int left , int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}