class Solution {
    public void reverseString(char[] s) {
        int lo =0 ;
        int hi = s.length-1;

        while(lo < hi){
            swap(s , lo, hi);
            lo++;
            hi--;
        }
    }

    public void swap(char[] s,int lo,int hi){
        char temp = s[lo];
        s[lo] = s[hi];
        s[hi] = temp;
    }
}