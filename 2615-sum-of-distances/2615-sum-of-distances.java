class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer,List<Integer>> dict = new HashMap<>();

        for(int i = 0;i < nums.length;i++){
            List<Integer> list = dict.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            dict.put(nums[i], list);
        }

        long[] ans = new long[nums.length];
        for(Map.Entry<Integer,List<Integer>> entry: dict.entrySet()){
            if(entry.getValue().size() == 1){
                int idx = entry.getValue().get(0);
                ans[idx] = 0;
            }else{
                List<Long> rtSum = getRightSum(entry.getValue());
                List<Long> ltSum = getLeftSum(entry.getValue());
                int size = entry.getValue().size();
                for(int i=0;i<size;i++){
                    int numElementBeforeHim = i;
                    int numElementAfterHim = size - i - 1;
                    int val = entry.getValue().get(i);
                    ans[val] = Math.abs((long) numElementAfterHim * val - rtSum.get(i)) 
         + Math.abs((long) numElementBeforeHim * val - ltSum.get(i));
                }
            }
        }

        return ans;
    }

    public List<Long> getRightSum(List<Integer> indexes){
        Long sum = 0L;
        List<Long> ans = new ArrayList<Long>();
        for(int i = indexes.size()-1;i >= 0 ; i--){
            ans.add(0,sum);
            sum += indexes.get(i);
        }
        return ans;
    }

    public List<Long> getLeftSum(List<Integer> indexes){
        Long sum = 0L;
        List<Long> ans = new ArrayList<Long>();
        for(int i = 0;i < indexes.size() ; i++){
            ans.add(sum);
            sum += indexes.get(i);
        }
        return ans;
    }
}