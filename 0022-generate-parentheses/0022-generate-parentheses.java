class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateCombinations(0,0,n,"");

        return ans;
    }

    public void generateCombinations(int open,int close,int n,String s){
        if(open == n && close == n){
            ans.add(s);
            return;
        }

        if(open < n){

            if(open == close)
                generateCombinations(open+1,close,n,s + "(");
            if(open > close)
               generateCombinations(open+1,close,n,s + "(");
        }

        if(close < n){
            if(close < open){
                generateCombinations(open,close+1,n,s + ")");
            }
        }
    }
}