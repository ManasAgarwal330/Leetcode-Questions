class Solution {
    public class Distance{
        int distance;
        int element;
        public Distance(int distance,int element){
            this.distance = distance;
            this.element = element;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Distance> maxHeap = new PriorityQueue<>((a,b) -> {
            if(a.distance == b.distance){
                return Integer.compare(b.element,a.element);
            }else{
                return Integer.compare(b.distance,a.distance);
            }
        });

        int temp = k;
        int i =0 ;
        while(k > 0){
            int distance = Math.abs(arr[i]-x);
            maxHeap.add(new Distance(distance,arr[i]));
            k--;
            i++;
        }

        while(i < arr.length){
            int distance = Math.abs(arr[i]-x);
            if(distance < maxHeap.peek().distance){
                maxHeap.poll();
                maxHeap.add(new Distance(distance,arr[i]));
            }
            i++;
        }

        List<Integer> ans = new ArrayList<>();
        while(maxHeap.size() != 0){
            ans.add(0,maxHeap.poll().element);
        }
        Collections.sort(ans);
        return ans;
    }
}