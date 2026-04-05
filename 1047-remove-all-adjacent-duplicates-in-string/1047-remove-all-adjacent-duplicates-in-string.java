class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(stack.size() > 0 && stack.peek() == ch){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }

        StringBuilder str = new StringBuilder();
        while(!stack.empty()){
            str.insert(0,stack.peek());
            stack.pop();
        }

        return str.toString();
    }
}