class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int[] lds = new int[nums.length];
        int[] lis = new int[nums.length];
        
        lds[0] = 0;
        lds[1] = 1;
        for(int i=2;i<nums.length;i++){
            if(nums[i-1] <= nums[i-2])lds[i] = lds[i-1]+1;
            else lds[i] = 1;
        }
        lis[nums.length-1] = 0;
        lis[nums.length-2] = 1;
        for(int i=nums.length-3;i>=0;i--){
            if(nums[i+2] >= nums[i+1])lis[i] = lis[i+1]+1;
            else lis[i] = 1;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(lds[i] >= k && lis[i] >= k)list.add(i);
        }
        
        // for(int val:lds){System.out.print(val+" ");}
        // System.out.println();
        // for(int val:lis)System.out.print(val+" ");
        // System.out.println();
        return list;
    }
}