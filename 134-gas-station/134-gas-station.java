class Solution {
    public int canCompleteCircuit(int[] A, int[] B) {
        int gasSum = 0;
        int costSum = 0;
        for(int i=0;i<A.length;i++){
            gasSum += A[i];
            costSum += B[i];
        }
        
        if(gasSum < costSum)return -1;
        
        int start = 0;
        int fuel = 0;
        for(int i=0;i<A.length;i++){
            fuel += A[i] - B[i];
            if(fuel < 0){
                start = i+1;
                fuel = 0;
            }
        }
        
        return start;
    }
}