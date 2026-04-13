class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else map.put(ch,1);
        }
        
        int i =0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(map.get(ch) == 1)
                return i;
            i++;
        }

        return -1;
    }
}