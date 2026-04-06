class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int ans = Integer.MIN_VALUE;

        while(right <  s.length())
        {
            char ch = s.charAt(right);
            if(set.contains(ch)){
                while(left < right && set.contains(ch)){
                    char chr = s.charAt(left);
                    set.remove(chr);
                    left++;
                }
            }else{
                ans = Math.max(ans,right-left+1);
            }
            set.add(ch);
            right++;
        } 

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}