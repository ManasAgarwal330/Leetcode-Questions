class Solution {
    public class FuelStation{
        int position;
        int fuel;
        public FuelStation(int position,int fuel){
            this.position = position;
            this.fuel = fuel;
        }
    }
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(target <= startFuel) return 0;
        PriorityQueue<FuelStation> maxHeap = new PriorityQueue<>((a,b) -> {
            if(a.fuel == b.fuel){
                return Integer.compare(b.position,a.position);
            }

            return Integer.compare(b.fuel,a.fuel);
        });

        for(int[] fuelStops: stations){
            maxHeap.add(new FuelStation(fuelStops[0],fuelStops[1]));
        }

        int currentPosition = 0;
        long currentFuel = startFuel;
        Queue<FuelStation> rem = new LinkedList<>();
        int minFuelStation = 0;
        while(!maxHeap.isEmpty()){
            if(currentPosition+currentFuel >= target){
                return minFuelStation;
            }
            FuelStation t = maxHeap.poll();
            if(t.position <= currentPosition+currentFuel){
                currentFuel = (currentFuel - (t.position - currentPosition)) + t.fuel;
                currentPosition = t.position;
                minFuelStation++;
                while(!rem.isEmpty()){
                    maxHeap.add(rem.poll());
                }
            }else{
                rem.add(t);
            }
        }

         if(currentPosition+currentFuel >= target){
                return minFuelStation;
            }

        return -1;
    }
}