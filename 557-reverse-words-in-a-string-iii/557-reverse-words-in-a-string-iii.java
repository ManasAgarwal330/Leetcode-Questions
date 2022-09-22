class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder st = new StringBuilder("");
        for(int i=0;i<words.length;i++){
            String str = words[i];
            StringBuilder strB = new StringBuilder(str).reverse();
            if(i != words.length-1)st.append(strB.toString()+" ");
            else st.append(strB.toString());
        }
        
        return st.toString();
    }
}