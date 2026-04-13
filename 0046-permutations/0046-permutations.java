class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> visited = new HashSet<>();
        permute(nums,visited,new ArrayList<Integer>());

        return ans;
    }

    public void permute(int[] nums, HashSet<Integer> visited , List<Integer> d){
        if(d.size() == nums.length){
            List<Integer> clone = new ArrayList<>(d);
            ans.add(clone);
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visited.contains(i)){
                visited.add(i);
                d.add(nums[i]);
                permute(nums,visited,d);
                visited.remove(i);
                d.remove(Integer.valueOf(nums[i]));
            }
        }
    }
}