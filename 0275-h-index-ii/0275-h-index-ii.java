class Solution {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length;
        int ans = 0;
        while(left <= right){
            int mid = (left + right)/2;
            if(isHValid(citations,mid)){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return ans;
    }

    public boolean isHValid(int[] citations,int h){
        int idx = -1;
        for(int i=0;i<citations.length;i++){
            if(citations[i] >= h){
                idx = i;
                break;

            }
        }
        if(idx == -1) return false;
        return (citations.length-idx) >= h ? true: false;
    }
}