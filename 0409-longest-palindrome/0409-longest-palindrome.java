class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> have = new HashMap<>();

        for(char ch: s.toCharArray()){
            have.put(ch,have.getOrDefault(ch,0)+1);
        }

        boolean plusOne = false;
        int ans = 0;
        for(Map.Entry<Character,Integer> entry: have.entrySet()){
            if(entry.getValue() % 2 == 1) plusOne = true;
            ans += (entry.getValue()/2)*2;
        }

        return plusOne ? ans + 1 : ans;
    }
}