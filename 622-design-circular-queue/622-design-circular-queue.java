class MyCircularQueue {
    
    int[] arr;
    int pos;
    int size;
    int stpos;
    public MyCircularQueue(int k) {
        arr = new int[k];
        pos = -1;
        size = 0;
        stpos = 0;
    }
    
    public boolean enQueue(int value) {
        if(size == arr.length)return false;
        pos = (pos+1)%arr.length;
        arr[pos] = value;
        size++;
        return true;
        
    }
    
    public boolean deQueue() {
        if(size == 0)return false;
        stpos = (stpos+1)%arr.length;
        size--;
        return true;
        
    }
    
    public int Front() {
       if(size == 0){
           return -1;
       }
        return arr[stpos];
        
    }
    
    public int Rear() {
        if(size == 0)return -1;
        return arr[pos];
    }
    
    public boolean isEmpty() {
        return size==0 ? true:false;
    }
    
    public boolean isFull() {
        return size == arr.length ? true : false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */