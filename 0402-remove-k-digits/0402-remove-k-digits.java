class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        
        for(char ch: num.toCharArray()){
            int number  = ch - '0';
            while(!stack.empty() && stack.peek() > number && k > 0){
                stack.pop();
                k=k-1;
            }

            stack.push(number);
        }

        while(k > 0 && !stack.empty()){
            k = k-1;
            stack.pop();
        }

        if(stack.size() == 0)return "0";

        StringBuilder ans = new StringBuilder();
        while(!stack.empty())
        {
            ans.insert(0,stack.peek());
            stack.pop();
        }

        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }

        ans.delete(0, i);

        return ans.length() == 0 ? "0" : ans.toString();
        
    }
}