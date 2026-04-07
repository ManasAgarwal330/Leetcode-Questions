class Solution {
    class Pair{
        int required;
        int have;
        public Pair(int required, int have){
            this.required = required;
            this.have = have;
        }

    }

    public List<Integer> findAnagrams(String s2, String s1) {
        HashMap<Character,Pair> map = new HashMap<>();
        int left = 0;
        int right = 0;
        List<Integer> ans = new ArrayList<>();
        while(left < s1.length()){
            char ch = s1.charAt(left);
            if(map.containsKey(ch)){
                map.get(ch).required++;
            }else{
                map.put(ch,new Pair(1,0));
            }
            left++;
        }

        left = 0;
        while(right < s2.length()){
            char ch = s2.charAt(right);
            if(map.containsKey(ch)){
                map.get(ch).have++;
                if(checkHashMap(map)){
                    ans.add(right-(s1.length()-1));
                    map.get(s2.charAt(left)).have--;
                    left++;
                    right++;
                    continue;
                }
                if(map.get(ch).required < map.get(ch).have){
                    while(left < right){
                        char ch2 = s2.charAt(left);
                        map.get(ch2).have--;
                        left++;
                        if(ch2 == ch){
                            break;
                        }
                    }
                }
            }else{
               while(left < right)
               {
                    char ch2 = s2.charAt(left);
                    map.get(ch2).have--;
                    left++;
               } 
               left = right+1;
            }
            right++;
        }

        return ans;
    }

    public boolean checkHashMap(HashMap<Character,Pair> map){
        for(Map.Entry<Character,Pair> e: map.entrySet()){
            char key = e.getKey();
            Pair val = e.getValue();
            
            if(val.required != val.have){
                return false;
            }
        }

        return true;
    }
}