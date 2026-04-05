class Solution {
    class Pair{
        char ch;
        int count;

        public Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(!stack.empty() && stack.peek().ch == ch && stack.peek().count == k-1){
                int remove = k-1;
                while(remove > 0){
                    stack.pop();
                    remove--;
                }
            }
            else if(!stack.empty() && stack.peek().ch == ch){
                Pair p = new Pair(ch,stack.peek().count + 1);
                stack.push(p);
            }
            else{
                Pair p = new Pair(ch,1);
                stack.push(p);
            }
        }

        StringBuilder st = new StringBuilder();
        while(!stack.empty()){
            st.insert(0,stack.peek().ch);
            stack.pop();
        }

        return st.toString();
    }
}