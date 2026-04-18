class Solution {
    class Result {
    int elements;
    boolean equal;

    Result(int elements, boolean equal) {
        this.elements = elements;
        this.equal = equal;
    }
}
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length-1][matrix[0].length-1];
        int ans = -1;
        while(left <= right){
            int guess = (left + right)/2;
           Result elements = numElementSmallerOrEqual(matrix,guess);
            if(elements.elements > k){
                ans = guess;
                right = guess-1;
            }else if(elements.elements < k){
                left = guess+1;
            }else{
                if(elements.equal){
                    return guess;
                }
                ans = guess;
                right = guess-1;
            }
        }

        return ans;
    }

    public Result numElementSmallerOrEqual(int[][] matrix, int target) {
    int elements = 0;
    boolean equal = false;
    int i = matrix.length - 1;
    int j = 0;

    while (i >= 0 && j < matrix[0].length) {
        int num = matrix[i][j];
        if (num > target) {
            i--;
        } else {
            if (num == target) {
                equal = true;
            }
            elements += i + 1;
            j++;
        }
    }

    return new Result(elements, equal);
}
}