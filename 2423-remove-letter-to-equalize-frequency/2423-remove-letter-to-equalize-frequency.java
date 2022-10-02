class Solution {
    public boolean equalFrequency(String word) {
        int[] arr = new int[26];
        for(char ch:word.toCharArray()){
            arr[ch-'a'] += 1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] != 0)map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        int flag = -1;
        int mx = (int)-1e9;
        for(int val:map.keySet()){
            if(mx < map.get(val)){
                mx = map.get(val);
                flag = val;
            }
        }
        
        boolean changeDone = false;
        for(int i=0;i<arr.length;i++){
             if(arr[i] != 0){
                if(arr[i] == flag){}
                else{
                    if(!changeDone){
                        if(Math.abs(arr[i]-flag) == 1){}
                        else return false;
                        changeDone = true;
                    }
                    else return false;
                }
            }
        }
        if(!changeDone){
            boolean ans = false;
            HashMap<Character,Integer> mp = new HashMap<>();
            for(char ch:word.toCharArray()){
                mp.put(ch,mp.getOrDefault(ch,0)+1);
            }
            if(mp.size() == 1)return true;
            else{
                for(char c:mp.keySet()){
                    if(mp.get(c) != 1)return false;
                }
            }
            
        }
        return true;
    }
}