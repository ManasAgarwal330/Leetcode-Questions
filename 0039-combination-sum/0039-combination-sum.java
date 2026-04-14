class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        checkSum(candidates,0,target,0,new ArrayList<Integer>());

        return ans;
    }

    public void checkSum(int[] candidates, int sum , int target,int pos, ArrayList<Integer> d){
        if(sum > target) return;
        else if(pos == candidates.length)return;
       
        int tar = sum+candidates[pos];
        if(tar == target){
            System.out.print(d.size());
            List<Integer> clone = new ArrayList<Integer>(d);
            clone.add(candidates[pos]);
            ans.add(clone);
        }
        d.add(candidates[pos]);
        checkSum(candidates,tar,target,pos,d);
        d.remove(Integer.valueOf(candidates[pos]));
        checkSum(candidates,sum,target,pos+1,d);
       

    }
}