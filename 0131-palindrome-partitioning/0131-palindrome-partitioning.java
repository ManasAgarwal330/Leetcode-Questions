class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        part(s,new ArrayList<String>());

        return ans;
    }

    public void part(String s,List<String> d){
        if(s.length() == 0){
            ArrayList<String> clone = new ArrayList<>(d);
            ans.add(clone);
            return; 
        }

        int len = 1;
        while(len <= s.length()){
            String left = s.substring(0,len); 
            String remaining = len == s.length() ? "" : s.substring(len,s.length());
            if(isPalindrome(left)){
                d.add(left);
                part(remaining,d);
                d.remove(d.size() - 1);
            }
            len++;
        }
        
    }


    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            char lch = s.charAt(left);
            char rch = s.charAt(right);

            if(lch != rch)return false;

            left++;
            right--;
        }

        return true;
    }
}