class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty())maxHeap.add(num);
        else if(maxHeap.peek() > num){
            if((maxHeap.size()+minHeap.size()) %2 == 0){
               maxHeap.add(num);
            }else{
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        }
        else if(maxHeap.peek() <= num)
        {
            if((maxHeap.size()+minHeap.size()) %2 == 1){
                minHeap.add(num);
            }else{
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if((maxHeap.size() + minHeap.size()) % 2 == 1){
            return maxHeap.peek();
        }else{
            return (double)((maxHeap.peek() + minHeap.peek())*1.0/2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */