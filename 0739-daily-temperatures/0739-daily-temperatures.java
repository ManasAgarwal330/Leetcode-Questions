class Solution {
    class Pair{
        int temp;
        int idx;

        public Pair(int temp,int idx){
            this.temp = temp;
            this.idx = idx;
        }

    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int i = temperatures.length-1;
        int[] ans = new int[temperatures.length];
        while(i >= 0){
            Pair p = new Pair(temperatures[i],i);
            while(!stack.empty() && stack.peek().temp <= temperatures[i])stack.pop();

            if(stack.empty()){
                ans[i] = 0;
            }else{
                int idx = stack.peek().idx;
                ans[i] = idx-i;
            }
            i--;
            stack.push(p);
        }

        return ans;
    }
}