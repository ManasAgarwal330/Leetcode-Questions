class Solution {
    public int totalFruit(int[] fruits) {
         HashMap<Integer,Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int ans = Integer.MIN_VALUE;
        int k =2 ;
        
        while(right < fruits.length)
        {
            int ch = fruits[right];
            
            if(map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }else
            {
                map.put(ch,1);
            }
            
            
            if(map.size() > k){
                while(left <= right && map.size() > k){
                    int chr = fruits[left];
                    if(map.get(chr) == 1){
                        map.remove(chr);
                    }else{
                        map.put(chr, map.getOrDefault(chr, 0) - 1);
                    }
                    left++;
                }
            }else{
                ans = Math.max(ans,right-left+1);
            }
            
            right++;
        }
        
        return ans;
    }
}