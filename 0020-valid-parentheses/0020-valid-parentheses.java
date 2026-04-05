class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(stack.size() == 0 && (ch == ']' || ch == '}' || ch == ')')){
                return false;
            }
            if((ch == ']' && stack.peek() != '[') || (ch == ')' && stack.peek() != '(') || (ch == '}' && stack.peek() != '{')){
                return false;
            }else if(ch == '[' || ch == '{' || ch == '('){
                stack.push(ch);
            }else{
                stack.pop();
            }
        }

        if(stack.size() > 0)
        {
            return false;
        }
        return true;
    }
}