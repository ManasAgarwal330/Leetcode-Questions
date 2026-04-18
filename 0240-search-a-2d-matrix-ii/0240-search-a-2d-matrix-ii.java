class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length-1;
        int j = 0;

        while(i >= 0 && j < matrix[0].length){
            int num = matrix[i][j];
            if(num > target){
                i--;
            }else if(num < target){
                j++;
            }else{
                return true;
            }
        }

        return false;
    }
}