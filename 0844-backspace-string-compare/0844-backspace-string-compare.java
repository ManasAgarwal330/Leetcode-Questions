class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder firstStr = new StringBuilder();
        StringBuilder secondStr = new StringBuilder();

        int countBackSpace = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            char c = s.charAt(i);
            if(c == '#'){
                countBackSpace++;
            }else if(countBackSpace > 0){
                countBackSpace--;
            }else{
                firstStr.append(c);
            }
        }

        countBackSpace = 0;
        for (int i = t.length()-1; i >=0 ; i--) {
            char c = t.charAt(i);
            if(c == '#'){
                countBackSpace++;
            }else if(countBackSpace > 0){
                countBackSpace--;
            }else{
                secondStr.append(c);
            }
        }

        return firstStr.toString().equals(secondStr.toString());
    }
}