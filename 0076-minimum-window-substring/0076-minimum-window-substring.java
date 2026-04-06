class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> required = new HashMap<>();
        HashMap<Character,Integer> have = new HashMap<>();

        int left = 0;
        int right = 0;
        String ans = ""; 
        while(left < t.length()){
            char ch = t.charAt(left);
            if(required.containsKey(ch)){
                required.put(ch,required.get(ch)+1);
            }else{
                required.put(ch,1);
            }
            left++;
        }

        left = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            if(have.containsKey(ch)){
                have.put(ch,have.get(ch)+1);
            }else{
                have.put(ch,1);
            }

            boolean conditionFulfilled = compareHashMap(required,have);

            if(conditionFulfilled){
                if(ans.length() == 0){
                    ans = s.substring(left,right+1);
                }else{
                    if(ans.length() > (right-left+1)){
                        ans = s.substring(left,right+1);
                    }
                }

                while(conditionFulfilled && left < right){
                    char ch2 = s.charAt(left);
                    if(have.get(ch2) == 1){
                        have.remove(ch2);
                    }else{
                        have.put(ch2,have.get(ch2)-1);
                    }
                    conditionFulfilled = compareHashMap(required,have);
                    left++;
                    if(conditionFulfilled && (ans.length() > (right-left+1))){
                        ans = s.substring(left,right+1);
                    }
                }
            }

            right++;
        }

        return ans;


    }

    public boolean compareHashMap(HashMap<Character,Integer> required,HashMap<Character,Integer> have){
        for(Map.Entry<Character,Integer> e: required.entrySet()){
            char key = e.getKey();
            int val = e.getValue();

            if(have.containsKey(key) && have.get(key) >= val){
                //kuch nhi krna
            }else {
                return false;
            }
        }

        return true;
    }
}