import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        MedianFinder md = new MedianFinder(k);

        double[] ans = new double[nums.length - k + 1];

        // First window
        for (int i = 0; i < k; i++) {
            md.addNum(nums[i]);
        }
        ans[0] = md.findMedian();

        int idx = 1;
        for (int i = k; i < nums.length; i++) {
            md.addNum(nums[i]);
            md.remove(nums[i - k]);
            ans[idx++] = md.findMedian();
        }

        return ans;
    }

    class MedianFinder {

        PriorityQueue<Long> maxHeap; // left (smaller half)
        PriorityQueue<Long> minHeap; // right (larger half)
        Map<Long, Integer> delayed;  // lazy deletion map

        int leftSize;  // valid elements in maxHeap
        int rightSize; // valid elements in minHeap

        public MedianFinder(int k) {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
            delayed = new HashMap<>();
            leftSize = 0;
            rightSize = 0;
        }

        public void addNum(long num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
                leftSize++;
            } else {
                minHeap.add(num);
                rightSize++;
            }
            balance();
        }

        public void remove(long num) {
            // mark for lazy deletion
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);

            if (num <= maxHeap.peek()) {
                leftSize--;
                if (num == maxHeap.peek()) {
                    prune(maxHeap);
                }
            } else {
                rightSize--;
                if (num == minHeap.peek()) {
                    prune(minHeap);
                }
            }
            balance();
        }

        public double findMedian() {
            if ((leftSize + rightSize) % 2 == 1) {
                return (double) maxHeap.peek();
            } else {
                return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
            }
        }

        private void balance() {
            // maintain size property
            if (leftSize > rightSize + 1) {
                minHeap.add(maxHeap.poll());
                leftSize--;
                rightSize++;
                prune(maxHeap);
            } else if (leftSize < rightSize) {
                maxHeap.add(minHeap.poll());
                leftSize++;
                rightSize--;
                prune(minHeap);
            }
        }

        private void prune(PriorityQueue<Long> heap) {
            while (!heap.isEmpty()) {
                long num = heap.peek();
                if (delayed.containsKey(num)) {
                    delayed.put(num, delayed.get(num) - 1);
                    if (delayed.get(num) == 0) {
                        delayed.remove(num);
                    }
                    heap.poll();
                } else {
                    break;
                }
            }
        }
    }
}