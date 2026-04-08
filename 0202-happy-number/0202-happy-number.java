class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while(true){
            fast = returnSquareOfNumbers(fast);
            fast = returnSquareOfNumbers(fast);
            slow = returnSquareOfNumbers(slow);
            if(slow == 1 || fast == 1){
                return true;
            }
            if(fast == slow){
                break;
            }
            
        }

        return false;
    }

    public int returnSquareOfNumbers(int num)
    {
        int ans = 0;
        while(num > 0){
            ans += Math.pow((num%10),2);
            num = num/10;
        }
        //System.out.println(ans);
        return ans;
    }
}