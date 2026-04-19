class Solution {
    class Result{
        int elements;
        boolean equal;
        public Result(int elements,boolean equal){
            this.elements = elements;
            this.equal = equal;
        }
    }
    public int findKthNumber(int m, int n, int k) {
        int left = 0;
        int right = m*n;
        int ans = 0;
        while(left <= right){
            int mid = (left+right)/2;
            Result elements = getSmallandEqualElements(m,n,mid);

            if(elements.elements > k){
                ans = mid;
                right = mid-1;
            }else if(elements.elements < k)
            {
                left = mid+1;
            }else{
                if(elements.equal)return mid;
                ans = mid;
                right = mid-1;
            }
        }

        return ans;
    }

    public Result getSmallandEqualElements(int m,int n, int guess){
        boolean equal = false;
        int i = m;
        int j = 1;
        int elements = 0;
        while(i >= 1 && j <= n){
            int num = i*j;
            if(num < guess){
                elements += i;
                j++;
            }else if(num > guess)
            {
                i--;
            }else{
                equal =  true;
                elements += i;
                j++;
            }
        }

        return new Result(elements,equal);
    }
}