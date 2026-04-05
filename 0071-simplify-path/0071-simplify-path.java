class Solution {
    public String simplifyPath(String path) {
        Stack<StringBuilder> stack = new Stack<>();
        int i = 0;
        while(i < path.length()){
            char ch = path.charAt(i);
            StringBuilder st = new StringBuilder();
            if(ch == '/')
            {
                i++;
                continue;
            }
            else
            {   
               while(i< path.length()){
                    ch = path.charAt(i);
                    // System.out.println(ch);
                    if(ch == '/'){
                        i--;
                        break;
                    }
                    st.append(ch);
                    i++;
                }
            }
            // System.out.println(st);
            if(st.toString().equals(".."))
            {
                if(!stack.empty())stack.pop();
            }else if(st.toString().equals(".")){
               
            }
            else{
                stack.push(st);
            }
            i++;
        }

        if(stack.empty())return "/";
        StringBuilder ans = new StringBuilder();
        while(!stack.empty()){
            ans.insert(0,stack.peek());
            ans.insert(0,"/");
            stack.pop();
        }

        return ans.toString();
    }
}