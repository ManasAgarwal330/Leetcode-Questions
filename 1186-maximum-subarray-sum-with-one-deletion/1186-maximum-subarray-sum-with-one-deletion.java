class Solution {
    public int maximumSum(int[] arr) {
        int maxSum = arr[0];
        int prevWithNoDel = arr[0];
        int prevWithOneDel = Integer.MIN_VALUE;

        for(int i=1;i< arr.length;i++){
            int currWithNoDel = prevWithNoDel+arr[i] > arr[i] ? prevWithNoDel+arr[i] : arr[i];
            int currWithOneDel = i == 1 ? Math.max(prevWithNoDel,arr[i]) : 
            (prevWithOneDel+arr[i] > prevWithNoDel ? prevWithOneDel+arr[i] : prevWithNoDel);

            maxSum = Math.max(maxSum,Math.max(currWithNoDel,currWithOneDel));
            prevWithNoDel = currWithNoDel;
            prevWithOneDel = currWithOneDel;
        }

        return maxSum;
    }
}